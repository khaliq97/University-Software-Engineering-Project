package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Osama Khaliq
 * Version (17/02/2016)
 * Login window functions
 * Responsible for reading User information and populating the User Database
 * As well Login and Logout functions
 */
public class Login extends Application {

    private Parent root;
    private FXMLLoader fxmlLoader;
    private Scene scene;
    private LoginController loginController;

    private ArrayList<User> database;

    StringBuilder jsonFile;

    private final String jsonFilePath = "info.json";


    /*
    Employee : 1
    HR Employee : 3
    Director : 5
    Manager: 4
    Reviewer: 2
     */

    /**
     * Initializes variables and loads "Login" Window
     * @param primaryStage Window stage
     * @throws Exception Stage exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        loginController = new LoginController(this);
        database = new ArrayList<>();
        jsonFile =  new StringBuilder();

        fxmlLoader.setController(loginController);
        root = fxmlLoader.load();

        scene = new Scene(root, 380, 210);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();

        initialize();
    }

    /**
     * Populates the Access Combo Box from loginController.
     * Reads JSON file and inputs data into the "database" ArrayList.
     */
    public void initialize()
    {
        loginController.populateAccessComboBox();

        readJSONFile();
        populateDatabase();

    }

    /**
     * Reads a file and writes it to jsonFile
     */
    public void readJSONFile()
    {
        String line = "";

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
            String name = jsonItem.getString("name");
            String password = jsonItem.getString("password");
            int authorization = jsonItem.getInt("auth");

            User user = new User(name, password, authorization);
            database.add(user);
        }

    }

    /**
     * Finds the given Username in database ArrayList
     * Checks user password against GUI input
     * Checks authorization level againt GUI input
     * If successful, login success is shown otherwise appropriate error messages are showed
     * @param username Username from txtFieldUsername
     * @param password Password from txtFieldPassword
     * @param authorization Authorization from comboBoxAccess
     */
    public void login(String username, String password, int authorization)
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
                if(potentialUser.getAuthorization() == authorization || potentialUser.getAuthorization() > authorization)
                {
                    loginController.showLoginSuccess();
                }else
                {
                    loginController.showAuthorizationFailureAlert();
                }

            }else
            {
                loginController.showIncorrectUsernameOrPasswordAlert();

            }
        }else
        {
            loginController.showIncorrectUsernameOrPasswordAlert();
        }



    }

    public void logout()
    {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
