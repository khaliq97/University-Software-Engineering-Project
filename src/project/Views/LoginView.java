package project.Views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;
import project.Authorization.AuthorizationServer;
import project.Controllers.LoginController;
import project.User.User;

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

    private Parent root;
    private Stage primaryStage;
    private FXMLLoader fxmlLoader;
    private Scene scene;
    private LoginController loginController;

    private AuthorizationServer authorizationServer;

    private ArrayList<User> database;

    private StringBuilder jsonFile;

    private final String jsonFilePath = "database.json";

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
        database = new ArrayList<>();
        jsonFile =  new StringBuilder();

        fxmlLoader.setController(loginController);
        root = fxmlLoader.load();

        scene = new Scene(root, 380, 210);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        authorizationServer = new AuthorizationServer(this);

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
     * Returns jsonFilePath
     * @return jsonFilePath
     */
    public String getJsonFilePath()
    {
        return jsonFilePath;
    }

    /**
     * Populates the Access Combo Box from loginController.
     * Reads JSON file and inputs data into the "database" ArrayList.
     */
    public void initialize()
    {
        loginController.populateAccessComboBox();

        readJSONFile();

    }

    /**
     * Checks if a File exists
     * @return
     */
    public boolean checkIfJSONFileExists()
    {
        File jsonFile = new File(jsonFilePath);
        if(jsonFile.exists() && !jsonFile.isDirectory())
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * Reads a file and writes it to jsonFile StringBuilder
     */
    public void readJSONFile()
    {
        String line = "";

        if(checkIfJSONFileExists())
        {
            try {
                FileReader fileReader = new FileReader(jsonFilePath);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                try {
                    while((line = bufferedReader.readLine()) != null)
                    {
                        jsonFile.append(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            populateDatabase();
        }else
        {
            loginController.showMissingJSONFileAlert(jsonFilePath);
            closeLoginView();
        }
    }

    /**
     * Parses JSON file as Array.
     * Stores each Username, Password and Authorization in variables
     * Creates new User with these attributes
     * Adds it to database ArrayList
     */
    public void populateDatabase()
    {
        JSONArray items  = new JSONArray(jsonFile.toString());
        for(Object object: items)
        {
            JSONObject jsonItem = (JSONObject) object;
            String name = jsonItem.getString("id");
            String password = jsonItem.getString("password");
            int authorization = jsonItem.getInt("auth");

            User user = new User(name, password, authorization);
            database.add(user);
        }


    }

    /**
     * Finds the given Username in database ArrayList
     * Checks user password against GUI input
     * If successful, loginView success is shown otherwise appropriate error messages are showed
     * @param username Username string from txtFieldUsername
     * @param password Password string from txtFieldPassword
     * @param authorization Authorization integer from comboBoxAuthorizationLevels
     */
    public boolean login(String username, String password, int authorization)
    {

        boolean userFound = false;
        User potentialUser = null;
        for(User user: database)
        {
            if(!userFound)
            {
                if(user.getUsername().equals(username))
                {
                    potentialUser = user;
                    userFound = true;
                }
            }

        }

        if(userFound)
        {
            if(potentialUser.getPassword().equals(password))
            {
                if(authorizationServer.authorizationCheck(potentialUser, authorization))
                {
                    primaryStage.close();
                    HomeView homeView = new HomeView(this, potentialUser);
                    homeView.loadHomePageView();

                    return true;

                }else
                {
                    loginController.showAuthorizationFailureAlert();
                    return false;
                }

            }else
            {
                loginController.loadForgotPasswordView();
                loginController.getTxtFieldPassword().clear();
                return false;

            }
        }else
        {
            loginController.loadForgotPasswordView();
            loginController.getTxtFieldPassword().clear();
            return false;
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}
