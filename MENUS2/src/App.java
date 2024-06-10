import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear los controles
        Label dateLabel = new Label("Selecciona una fecha:");
        DatePicker datePicker = new DatePicker();

        Label colorLabel = new Label("Selecciona un color:");
        ColorPicker colorPicker = new ColorPicker();

        Button confirmButton = new Button("Confirmar selección");

        // Configurar la acción del botón
        confirmButton.setOnAction(event -> {
            // Obtener la fecha y el color seleccionados
            String selectedDate = datePicker.getValue() != null ? datePicker.getValue().toString() : "Ninguna fecha seleccionada";
            String selectedColor = colorPicker.getValue() != null ? colorPicker.getValue().toString() : "Ningún color seleccionado";

            // Mostrar las selecciones en la consola
            System.out.println("Fecha seleccionada: " + selectedDate);
            System.out.println("Color seleccionado: " + selectedColor);

            // Mostrar un mensaje de confirmación
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText(null);
            alert.setContentText("Selección guardada con éxito:\nFecha: " + selectedDate + "\nColor: " + selectedColor);
            alert.showAndWait();
        });

        // Organizar los controles en un VBox
        VBox vbox = new VBox(10, dateLabel, datePicker, colorLabel, colorPicker, confirmButton);
        vbox.setAlignment(Pos.CENTER);
        VBox.setMargin(dateLabel, new Insets(0, 0, 0, 20));
        VBox.setMargin(datePicker, new Insets(0, 0, 0, 20));
        VBox.setMargin(colorLabel, new Insets(0, 0, 0, 20));
        VBox.setMargin(colorPicker, new Insets(0, 0, 0, 20));
        VBox.setMargin(confirmButton, new Insets(0, 0, 0, 20));

        // Crear la escena y mostrarla
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Date and Color Picker");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
