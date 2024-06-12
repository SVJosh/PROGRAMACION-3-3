import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        addControlsToGridPane(gridPane);

        Scene scene = new Scene(gridPane, 600, 600);

        primaryStage.setTitle("All Controls");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addControlsToGridPane(GridPane gridPane) {
        Label buttonLabel = new Label("Button:");
        GridPane.setHalignment(buttonLabel, javafx.geometry.HPos.RIGHT);
        gridPane.add(buttonLabel, 0, 0);
        Button button = new Button("Button");
        GridPane.setHalignment(button, javafx.geometry.HPos.LEFT);
        gridPane.add(button, 1, 0);

        Label checkBoxLabel = new Label("CheckBox:");
        GridPane.setHalignment(checkBoxLabel, javafx.geometry.HPos.RIGHT);
        gridPane.add(checkBoxLabel, 0, 1);
        CheckBox checkBox = new CheckBox("CheckBox");
        GridPane.setHalignment(checkBox, javafx.geometry.HPos.LEFT);
        gridPane.add(checkBox, 1, 1);

        Label hyperlinkLabel = new Label("Hyperlink:");
        GridPane.setHalignment(hyperlinkLabel, javafx.geometry.HPos.RIGHT);
        gridPane.add(hyperlinkLabel, 0, 2);
        Hyperlink hyperlink = new Hyperlink("Hyperlink");
        GridPane.setHalignment(hyperlink, javafx.geometry.HPos.LEFT);
        gridPane.add(hyperlink, 1, 2);

        Label toggleButtonLabel = new Label("ToggleButton:");
        GridPane.setHalignment(toggleButtonLabel, javafx.geometry.HPos.RIGHT);
        gridPane.add(toggleButtonLabel, 0, 3);
        ToggleButton toggleButton = new ToggleButton("ToggleButton");
        GridPane.setHalignment(toggleButton, javafx.geometry.HPos.LEFT);
        gridPane.add(toggleButton, 1, 3);

        Label radioButtonLabel = new Label("RadioButton:");
        GridPane.setHalignment(radioButtonLabel, javafx.geometry.HPos.RIGHT);
        gridPane.add(radioButtonLabel, 0, 4);
        RadioButton radioButton = new RadioButton("RadioButton");
        GridPane.setHalignment(radioButton, javafx.geometry.HPos.LEFT);
        gridPane.add(radioButton, 1, 4);

        Label labelLabel = new Label("Label:");
        GridPane.setHalignment(labelLabel, javafx.geometry.HPos.RIGHT);
        gridPane.add(labelLabel, 0, 5);
        Label label = new Label("Label");
        GridPane.setHalignment(label, javafx.geometry.HPos.LEFT);
        gridPane.add(label, 1, 5);

        Label textFieldLabel = new Label("TextField:");
        GridPane.setHalignment(textFieldLabel, javafx.geometry.HPos.RIGHT);
        gridPane.add(textFieldLabel, 0, 6);
        TextField textField = new TextField();
        textField.setPromptText("some text...");
        GridPane.setHalignment(textField, javafx.geometry.HPos.LEFT);
        gridPane.add(textField, 1, 6);

        Label passwordFieldLabel = new Label("PasswordField:");
        GridPane.setHalignment(passwordFieldLabel, javafx.geometry.HPos.RIGHT);
        gridPane.add(passwordFieldLabel, 0, 7);
        PasswordField passwordField = new PasswordField();
        GridPane.setHalignment(passwordField, javafx.geometry.HPos.LEFT);
        gridPane.add(passwordField, 1, 7);

        Label textAreaLabel = new Label("TextArea:");
        GridPane.setHalignment(textAreaLabel, javafx.geometry.HPos.RIGHT);
        gridPane.add(textAreaLabel, 0, 8);
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setText("This is very long text that will wrap to\nseveral lines.");
        GridPane.setHalignment(textArea, javafx.geometry.HPos.LEFT);
        gridPane.add(textArea, 1, 8, 1, 3);

        Label progressIndicatorLabel = new Label("ProgressIndicator:");
        GridPane.setHalignment(progressIndicatorLabel, javafx.geometry.HPos.RIGHT);
        gridPane.add(progressIndicatorLabel, 0, 11);
        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setProgress(0.49);
        GridPane.setHalignment(progressIndicator, javafx.geometry.HPos.LEFT);
        gridPane.add(progressIndicator, 1, 11);

        Label progressBarLabel = new Label("ProgressBar:");
        GridPane.setHalignment(progressBarLabel, javafx.geometry.HPos.RIGHT);
        gridPane.add(progressBarLabel, 0, 12);
        ProgressBar progressBar = new ProgressBar();
        progressBar.setProgress(0.49);
        GridPane.setHalignment(progressBar, javafx.geometry.HPos.LEFT);
        gridPane.add(progressBar, 1, 12);

        Label sliderLabel = new Label("Slider:");
        GridPane.setHalignment(sliderLabel, javafx.geometry.HPos.RIGHT);
        gridPane.add(sliderLabel, 0, 13);
        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(49);
        GridPane.setHalignment(slider, javafx.geometry.HPos.LEFT);
        gridPane.add(slider, 1, 13);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
