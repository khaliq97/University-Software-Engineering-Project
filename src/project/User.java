package project;

import org.json.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;


/**
 * Created by osamakhaliq on 18/02/17.
 */
public class User {

    private String username;

    private String password; //Crypt needed
    private int authorization;

    public User(String username, String password, int authorization)
    {
        this.username = username;
        this.password = password;
        this.authorization = authorization;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public int getAuthorization()
    {
        return authorization;
    }



}
