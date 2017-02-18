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
    LoginView loginView;

    private Parent root;
    private Stage stage;
    private FXMLLoader fxmlLoader;
    private Scene scene;
    private HomeController homeController;

    private User user;


    public HomeView(LoginView loginView, User user)
    {
        fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        stage = new Stage();
        homeController = new HomeController(this, loginView);

        fxmlLoader.setController(homeController);
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root, 745, 528);
        stage.setTitle("Home");
        stage.setScene(scene);

        this.loginView = loginView;
        this.user = user;
    }

    public void logout()
    {
        user.setLoggedIn(false);
        System.out.println(user.getUsername() + " has logged out");
        user = null;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public void show()
    {
        stage.show();
    }

    public void close()
    {
        stage.close();
    }
}
