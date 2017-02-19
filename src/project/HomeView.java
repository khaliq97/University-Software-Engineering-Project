package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Osama Khaliq
 * Version (19/02/2016)
 * HomeView window functions
 * Window is shown when the user successfully logs in
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


    /**
     * Constructor for HomeView class
     * Passes in loginView and User
     * @param loginView LoginView instance
     * @param user User that has logged in
     */
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
        user = null;
    }

    /**
     * Returns user
     * @return User
     */
    public User getUser()
    {
        return user;
    }

    /**
     * Sets the user from the parameter
     * @param user User to set
     */
    public void setUser(User user)
    {
        this.user = user;
    }

    /**
     * Method shows the stage
     */
    public void show()
    {
        stage.show();
    }

    /**
     * Method closes the stage
     */
    public void close()
    {
        stage.close();
    }
}
