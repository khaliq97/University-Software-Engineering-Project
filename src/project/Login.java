package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class Login extends Application {

    private Parent root;
    private FXMLLoader fxmlLoader;
    private Scene scene;
    private LoginController loginController;
    private ArrayList<User> database;

    private ArrayList<String> arrayListJsonFile;
    StringBuilder jsonFile;
    private final String fileName = "info.json";

    /*
    Employee : 1
    HR Employee : 3
    Director : 5
    Manager: 4
    Reviewer: 2
     */


    @Override
    public void start(Stage primaryStage) throws Exception{
        fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        loginController = new LoginController(this);
        database = new ArrayList<>();
        arrayListJsonFile = new ArrayList<>();
        jsonFile =  new StringBuilder();

        fxmlLoader.setController(loginController);
        root = fxmlLoader.load();

        scene = new Scene(root, 380, 210);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();

        initialize();
    }

    public void initialize()
    {
        loginController.populateAccessComboBox();

        readJSONFile();
        populateDatabase();

    }

    public void readJSONFile()
    {
        String line = "";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            try {
                while((line = bufferedReader.readLine()) != null)
                {
                    arrayListJsonFile.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(String jsonLine: arrayListJsonFile)
        {
            jsonFile.append(jsonLine);
        }
    }

    public void populateDatabase()
    {
        JSONArray items  = new JSONArray(jsonFile.toString());
        for(Object o: items)
        {
            JSONObject jsonItem = (JSONObject) o;
            String name = jsonItem.getString("name");
            String password = jsonItem.getString("password");
            int authorization = jsonItem.getInt("auth");

            User user = new User(name, password, authorization);
            System.out.println(user.getUsername() + " | Auth: " + authorization);
            database.add(user);
        }

    }

    public void login(String username, String password, int authorization)
    {

        for(User user: database)
        {
            if(user.getUsername().equals(username))
            {
                if(user.getPassword().equals(password))
                {
                    if(user.getAuthorization() == authorization || user.getAuthorization() > authorization)
                    {
                        System.out.println("Login Success");
                    }else
                    {
                        System.out.println("Authorization failure");
                    }

                }else
                {
                    System.out.println("Incorrect Password");
                }
            }else
            {
                System.out.println("Username does not exist");
            }
        }


    }

    public void logout()
    {

    }


    public static void main(String[] args) {
        launch(args);
    }
}
