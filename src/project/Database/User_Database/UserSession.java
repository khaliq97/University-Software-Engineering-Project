package project.Database.User_Database;

import project.Database.User.User;
import project.Database.User_Database.AuthorizationServer;
import project.Database.User_Database.Database;

/**
 * Created by Osama Khaliq
 * Version (19/02/2016)
 * Class stores the database and authorizationServer
 * Responsible for executing login() and logout() on server side
 * Login and logout methods for User
 */
public class UserSession {

    private Database database;
    private AuthorizationServer authorizationServer;


    private User user;

    /**
     * Class constructor
     */
    public UserSession()
    {
        database = new Database();
        authorizationServer = new AuthorizationServer();
    }

    /**
     * Returns user object
     * @return user
     */
    public User getUser()
    {
        return user;
    }

    /**
     * Returns database class
     * @return database
     */
    public Database getDatabase()
    {
        return database;
    }

    /**
     * Finds the given Username in database ArrayList
     * Checks user, password and authorization against input
     * If successful, returns "SUCCESS", otherwise returns the appropriate flags
     * @param username Username string
     * @param password Password string
     * @param authorization Database integer
     */
    public String login(String username, String password, int authorization)
    {

        boolean userFound = false;
        User potentialUser = null;
        for(User user: database.getDatabase())
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
                    user = potentialUser;
                    return "SUCCESS";

                }else
                {
                    return "AUTH_FAILURE";
                }

            }else
            {
                return "USER_PASS_FAILURE";

            }
        }else
        {

            return "USER_PASS_FAILURE";
        }


    }

    /**
     * Logs out the user
     */
    public void logout()
    {
        user.setLoggedIn(false);
    }
}
