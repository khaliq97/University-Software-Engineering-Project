package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

    private Parent root;
    private FXMLLoader fxmlLoader;
    private Scene scene;
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        controller = new Controller();

        fxmlLoader.setController(controller);
        root = fxmlLoader.load();

        scene = new Scene(root, 380, 210);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();

        controller.populateAccessComboBox();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
