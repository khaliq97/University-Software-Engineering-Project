package project.Database;

import org.json.JSONArray;
import org.json.JSONObject;
import project.Database.User.User;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Osama Khaliq
 * Version (19/02/2016)
 * Class stores the database from the database.json JSON file
 * Responsible for reading the file and populating the database ArrayList from JSON file
 */
public class Database {

    private AuthorizationServer authorizationServer;

    private ArrayList<User> database;

    private StringBuilder jsonFile;

    private final String jsonFilePath = "database.json";

    /**
     * Class constructor
     */
    public Database()
    {
        authorizationServer = new AuthorizationServer();
        database = new ArrayList<>();
        jsonFile = new StringBuilder();

        initialize();

    }

    /**
     * Method initializes database
     */
    public void initialize()
    {
        readJSONFile();
        populateDatabase();
    }

    /**
     * Returns database ArrayList
     * @return database
     */
    public ArrayList<User> getDatabase()
    {
        return database;
    }

    /**
     * Checks if database.json JSON File exists
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
    public boolean readJSONFile()
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

            return true;
        }else
        {
            return false;
        }
    }

    /**
     * Parses JSON file as Array.
     * Stores each Username, Password and Database in variables
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


}
