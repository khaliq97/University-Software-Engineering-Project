package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by osamakhaliq on 18/02/17.
 */
public class HomeView
{
    private Parent root;
    private Stage stage;
    private FXMLLoader fxmlLoader;
    private Scene scene;
    private HomeController homeController;


    public HomeView()
    {
        fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        stage = new Stage();
        homeController = new HomeController(this);

        fxmlLoader.setController(homeController);
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root, 380, 210);
        stage.setTitle("Home");
        stage.setScene(scene);
    }

    public void show()
    {
        stage.show();
    }
}
