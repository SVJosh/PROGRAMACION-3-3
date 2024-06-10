import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("Archivo");
        Menu editMenu = new Menu("Editar");
        Menu helpMenu = new Menu("Ayuda");

        MenuItem newItem = new MenuItem("Nuevo");
        MenuItem openItem = new MenuItem("Abrir");
        MenuItem saveItem = new MenuItem("Guardar");

        fileMenu.getItems().addAll(newItem, openItem, saveItem);

        MenuItem cutItem = new MenuItem("Cortar");
        MenuItem copyItem = new MenuItem("Copiar");
        MenuItem pasteItem = new MenuItem("Pegar");

        editMenu.getItems().addAll(cutItem, copyItem, pasteItem);


        MenuItem aboutItem = new MenuItem("Acerca de");

        helpMenu.getItems().addAll(aboutItem);


        Button exitButton = new Button("Salir");
        exitButton.setOnAction(e -> {
            System.out.println("Saliendo de la aplicación");
            primaryStage.close();
        });

        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        HBox hbox = new HBox(menuBar, exitButton);

        BorderPane root = new BorderPane();
        root.setTop(hbox);

        newItem.setOnAction(e -> System.out.println("Nuevo archivo creado"));
        openItem.setOnAction(e -> System.out.println("Archivo abierto"));
        saveItem.setOnAction(e -> System.out.println("Archivo guardado"));
        cutItem.setOnAction(e -> System.out.println("Texto cortado"));
        copyItem.setOnAction(e -> System.out.println("Texto copiado"));
        pasteItem.setOnAction(e -> System.out.println("Texto pegado"));
        aboutItem.setOnAction(e -> showAlert());

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Implementación de un Sistema de Menús en una Aplicación JavaFX");
        primaryStage.show();
    }

    private void showAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Acerca de");
        alert.setHeaderText(null);
        alert.setContentText("Esta es una aplicación de ejemplo con una barra de menú.");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
