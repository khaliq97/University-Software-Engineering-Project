package project;



/**
 * Created by osamakhaliq on 18/02/17.
 * User object class
 * Stores username, password and authorization of the given user
 * Has isLoggedIn to check weather the User is logged into the system
 */
public class User {

    private String username;

    private String password; //Crypt needed
    private int authorization;

    private boolean isLoggedIn;

    /**
     * User constructor
     * isLoggedIn is default set to false
     * @param username Username
     * @param password User password
     * @param authorization user's authorization level
     */
    public User(String username, String password, int authorization)
    {
        this.username = username;
        this.password = password;
        this.authorization = authorization;

        isLoggedIn = false;

    }

    /**
     * Returns User's username
     * @return username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Returns User's password
     * @return password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Returns User's authorization
     * @return authorization
     */
    public int getAuthorization()
    {
        return authorization;
    }

    /**
     * Returns boolean of if the User is logged in
     * @return isLoggedin
     */
    public boolean isLoggedIn()
    {
        return isLoggedIn;
    }

    /**
     * Sets isLogged in boolean value
     * @param loggedIn If the user is logged in or not
     */
    public void setLoggedIn(boolean loggedIn)
    {
        isLoggedIn = loggedIn;
    }




}
