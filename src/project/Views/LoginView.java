package project.Views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;
import project.Database.AuthorizationServer;
import project.Controllers.LoginController;
import project.Database.Database;
import project.Database.UserSession;
import project.User.User;
import sun.rmi.runtime.Log;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Osama Khaliq
 * Version (19/02/2016)
 * LoginView window functions
 * Responsible for reading User information and populating the User Database
 * As well LoginView and Logout functions
 */
public class LoginView extends Application {

    private UserSession userSession;

    private Parent root;
    private Stage primaryStage;
    private FXMLLoader fxmlLoader;
    private Scene scene;
    private LoginController loginController;


    /**
     * Initializes variables and loads "LoginView" Window
     * @param primaryStage Window stage
     * @throws Exception Stage exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {

        fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Login.fxml"));
        this.primaryStage = primaryStage;
        loginController = new LoginController(this);

        userSession = new UserSession();

        fxmlLoader.setController(loginController);
        root = fxmlLoader.load();
        scene = new Scene(root, 380, 210);

        primaryStage.setTitle("Database");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        initialize();
    }

    /**
     * Returns loginController class
     * @return loginController
     */
    public LoginController getLoginController()
    {
        return loginController;
    }
    /**
     * Loads the LoginView window
     */
    public void loadLoginView()
    {
        primaryStage.show();
    }

    /**
     * Closes LoginView window
     */
    public void closeLoginView()
    {
        primaryStage.close();
    }

    /**
     * Populates the Access Combo Box from loginController.
     * Reads JSON file and inputs data into the "database" ArrayList.
     */
    public void initialize()
    {
        loginController.populateAccessComboBox();

    }

    public boolean login(String username, String password, int authorization)
    {
        boolean returnBoolean = false;
        String loginFlag = userSession.login(username, password,authorization);

        if(loginFlag.equals("SUCCESS"))
        {
            primaryStage.close();
            HomeView homeView = new HomeView(this, userSession);
            homeView.getHomeController().checkAuthorization(authorization);
            homeView.loadHomePageView();
            returnBoolean = true;
        }else if(loginFlag.equals("AUTH_FAILURE"))
        {
            loginController.showAuthorizationFailureAlert();
            returnBoolean =  false;

        }else if(loginFlag.equals("USER_PASS_FAILURE"))
        {
            loginController.showIncorrectUsernameOrPasswordAlert();
            returnBoolean = false;
        }

        return returnBoolean;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
