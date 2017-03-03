package project.Database;

import org.json.JSONArray;
import org.json.JSONObject;
import project.User.User;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by osamakhaliq on 03/03/17.
 */
public class Database {

    private AuthorizationServer authorizationServer;

    private ArrayList<User> database;

    private StringBuilder jsonFile;

    private final String jsonFilePath = "database.json";

    public Database()
    {
        authorizationServer = new AuthorizationServer();
        database = new ArrayList<>();
        jsonFile = new StringBuilder();

        initialize();

    }

    public void initialize()
    {
        readJSONFile();
        populateDatabase();
    }

    /**
     * Returns jsonFilePath
     * @return jsonFilePath
     */
    public String getJsonFilePath()
    {
        return jsonFilePath;
    }


    public ArrayList<User> getDatabase()
    {
        return database;
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
