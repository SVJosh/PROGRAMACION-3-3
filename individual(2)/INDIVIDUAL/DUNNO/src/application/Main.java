package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends Application {

    private TableView<Driver> tableView = new TableView<>();
    private ComboBox<Integer> yearComboBox = new ComboBox<>();

    @Override
    public void start(Stage primaryStage) {
        // ComboBox for the year selection
        Text yearLabel = new Text("Año:");

        yearComboBox.setOnAction(event -> loadData(yearComboBox.getValue()));

        // TableView for displaying driver information
        TableColumn<Driver, String> driverNameColumn = new TableColumn<>("Driver Name");
        driverNameColumn.setCellValueFactory(new PropertyValueFactory<>("driverName"));

        TableColumn<Driver, Integer> winsColumn = new TableColumn<>("Wins");
        winsColumn.setCellValueFactory(new PropertyValueFactory<>("wins"));

        TableColumn<Driver, Integer> totalPointsColumn = new TableColumn<>("Total Points");
        totalPointsColumn.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));

        TableColumn<Driver, Integer> rankColumn = new TableColumn<>("Rank");
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));

        // Set the width of the columns to be equal and fill the width of the table
        double tableWidth = 600;
        double columnWidth = tableWidth / 4;
        driverNameColumn.setPrefWidth(columnWidth);
        winsColumn.setPrefWidth(columnWidth);
        totalPointsColumn.setPrefWidth(columnWidth);
        rankColumn.setPrefWidth(columnWidth);

        // Center align the column headers
        driverNameColumn.setStyle("-fx-alignment: CENTER;");
        winsColumn.setStyle("-fx-alignment: CENTER;");
        totalPointsColumn.setStyle("-fx-alignment: CENTER;");
        rankColumn.setStyle("-fx-alignment: CENTER;");

        tableView.getColumns().addAll(driverNameColumn, winsColumn, totalPointsColumn, rankColumn);

        // Layout
        HBox hBox = new HBox(10, yearLabel, yearComboBox);
        hBox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(10, hBox, tableView);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, tableWidth, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Driver Information");
        primaryStage.show();

        // Load years into ComboBox
        loadYears();
    }

    private void loadYears() {
        String url = "jdbc:postgresql://localhost:5432/formula1";
        String user = "postgres";
        String password = "admin12345";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            String query = "SELECT DISTINCT year FROM races";
            ResultSet resultSet = statement.executeQuery(query);

            List<Integer> years = new ArrayList<>();
            while (resultSet.next()) {
                int year = resultSet.getInt("year");
                years.add(year);
            }

            // Sort the years in descending order and set the items in the ComboBox
            years.sort(Comparator.reverseOrder());
            yearComboBox.getItems().setAll(years);

            // Set the default value to the highest year
            if (!years.isEmpty()) {
                yearComboBox.setValue(years.get(0));
                loadData(yearComboBox.getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadData(int year) {
        List<Driver> drivers = fetchDriversFromDatabase(year);
        tableView.getItems().setAll(drivers);
    }

    private List<Driver> fetchDriversFromDatabase(int year) {
        List<Driver> drivers = new ArrayList<>();
        String url = "jdbc:postgresql://localhost:5432/formula1";
        String user = "postgres";
        String password = "admin12345";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // Query to get driver details and their total points and ranks
            String query = "SELECT d.driver_id, d.forename, d.surname, ds.wins, ds.points, ds.position " +
                           "FROM driver_standings ds " +
                           "JOIN races ra ON ds.race_id = ra.race_id " +
                           "JOIN drivers d ON ds.driver_id = d.driver_id " +
                           "WHERE ra.year = " + year;

            ResultSet resultSet = statement.executeQuery(query);

            Map<Integer, Driver> driverMap = new HashMap<>();

            while (resultSet.next()) {
                int driverId = resultSet.getInt("driver_id");
                String driverName = resultSet.getString("forename") + " " + resultSet.getString("surname");
                int wins = resultSet.getInt("wins");
                int points = resultSet.getInt("points");
                int rank = resultSet.getInt("position");

                Driver driver = driverMap.getOrDefault(driverId, new Driver(driverName, 0, 0, rank));
                driver.setWins(driver.getWins() + wins);
                driver.setTotalPoints(driver.getTotalPoints() + points);
                if (rank > 0) {
                    driver.setRank(rank);
                }

                driverMap.put(driverId, driver);
            }

            drivers.addAll(driverMap.values());

            // Sort drivers first by rank (ascending) then by total points (descending) 
            // with rank 0 drivers at the end
            drivers.sort(Comparator.comparingInt(Driver::getRank).thenComparing(Driver::getTotalPoints, Comparator.reverseOrder())
                    .thenComparing(d -> d.getRank() == 0 ? 1 : 0));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return drivers;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Driver {
        private String driverName;
        private int wins;
        private int totalPoints;
        private int rank;

        public Driver(String driverName, int wins, int totalPoints, int rank) {
            this.driverName = driverName;
            this.wins = wins;
            this.totalPoints = totalPoints;
            this.rank = rank;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public int getWins() {
            return wins;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public int getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints(int totalPoints) {
            this.totalPoints = totalPoints;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }
}

