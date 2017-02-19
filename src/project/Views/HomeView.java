package project.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.Controllers.HomeController;
import project.User.User;

import java.io.IOException;

/**
 * Created by Osama Khaliq
 * Version (19/02/2016)
 * HomeView window functions
 * Window is shown when the user successfully logs in
 */
public class HomeView
{
    private LoginView loginView;

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
        fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Home.fxml"));
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

        initialize();

    }

    /**
     * Initializes controls in Class
     * Sets the text of the labelWelcome control
     */
    public void initialize()
    {
        homeController.setLabelWelcome(("User: " + user.getUsername() + ", you're are logged in as " + getAuthorizationLevelFromInt(user.getAuthorization())));
    }

    /**
     * Logs out the user
     * Sets the user to null
     */
    public void logout()
    {
        user.setLoggedIn(false);
        user = null;
    }

    /**
     * Method takes in a level of access number
     * Converts it to the Authorization String corresponding to that number
     * @param value Authorization level
     * @return Converted string
     */
    public String getAuthorizationLevelFromInt(int value)
    {

        String returnValue = "";
        switch (value)
        {
            //Converts the String in ComboBox to the corresponding authorization number
            case 1:
                returnValue = "Employee";
                break;
            case 2:
                returnValue =  "Reviewer";
                break;
            case 3:
                returnValue = "HR Employee";
                break;
            case 4:
                returnValue =  "Manager";
                break;
            case 5:
                returnValue = "Director";
                break;
        }

        return returnValue;
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
     * Loads the HomeView window
     */
    public void loadHomeView()
    {
        stage.show();
    }

    /**
     * Loads the HomeView window
     */
    public void closeHomeView()
    {
        stage.close();
    }
}
