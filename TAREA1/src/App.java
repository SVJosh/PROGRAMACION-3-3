import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane root = new AnchorPane();

        Label etiqueta1 = new Label("Nombre:");
        Label etiqueta2 = new Label("Nombre:");
        Label etiqueta3 = new Label("Nombre:");
        Label etiqueta4 = new Label("Nombre:");
        Label etiqueta5 = new Label("Nombre:");
        TextField nameTextField = new TextField();
        ListView<String> nameListView = new ListView<>();

        nameTextField.setPrefColumnCount(27);
        nameTextField.setStyle("-fx-background-color: blue; -fx-text-fill: wite;");

        nameListView.setStyle("-fx-background-color: black;");

        Image image1 = new Image("user.png");
        Image image2 = new Image("user.png");
        Image image3 = new Image("user.png");
        Image image4 = new Image("user.png");
        Image image5 = new Image("user.png");

        ImageView imagev1 = new ImageView(image1);
        ImageView imagev2 = new ImageView(image2);
        ImageView imagev3 = new ImageView(image3);
        ImageView imagev4 = new ImageView(image4);
        ImageView imagev5 = new ImageView(image5);

        imagev1.setFitWidth(30);
        imagev1.setFitHeight(30);
        imagev2.setFitWidth(30);
        imagev2.setFitHeight(30);
        imagev3.setFitWidth(30);
        imagev3.setFitHeight(30);
        imagev4.setFitWidth(30);
        imagev4.setFitHeight(30);
        imagev5.setFitWidth(30);
        imagev5.setFitHeight(30);

        root.getChildren().addAll(etiqueta1, etiqueta2, etiqueta3, etiqueta4, etiqueta5,
                nameTextField, nameListView, imagev1, imagev2, imagev3,
                imagev4, imagev5);

        AnchorPane.setTopAnchor(etiqueta1, 10d);
        AnchorPane.setLeftAnchor(etiqueta1, 50d);

        AnchorPane.setTopAnchor(etiqueta2, 50d);
        AnchorPane.setLeftAnchor(etiqueta2, 50d);

        AnchorPane.setTopAnchor(etiqueta3, 90d);
        AnchorPane.setLeftAnchor(etiqueta3, 50d);

        AnchorPane.setTopAnchor(etiqueta4, 130d);
        AnchorPane.setLeftAnchor(etiqueta4, 50d);

        AnchorPane.setTopAnchor(etiqueta5, 170d);
        AnchorPane.setLeftAnchor(etiqueta5, 50d);

        AnchorPane.setBottomAnchor(nameTextField, 10d);
        AnchorPane.setRightAnchor(nameTextField, 10d);

        AnchorPane.setTopAnchor(nameListView, 10d);
        AnchorPane.setRightAnchor(nameListView, 10d);

        AnchorPane.setTopAnchor(imagev1, 10d);
        AnchorPane.setLeftAnchor(imagev1, 10d);

        AnchorPane.setTopAnchor(imagev2, 50d);
        AnchorPane.setLeftAnchor(imagev2, 10d);

        AnchorPane.setTopAnchor(imagev3, 90d);
        AnchorPane.setLeftAnchor(imagev3, 10d);

        AnchorPane.setTopAnchor(imagev4, 130d);
        AnchorPane.setLeftAnchor(imagev4, 10d);

        AnchorPane.setTopAnchor(imagev5, 170d);
        AnchorPane.setLeftAnchor(imagev5, 10d);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TAREA1");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
