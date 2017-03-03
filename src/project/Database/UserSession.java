package project.Database;

import project.Database.User.User;

/**
 * Created by osamakhaliq on 03/03/17.
 */
public class UserSession {

    private Database database;
    private AuthorizationServer authorizationServer;


    private User user;

    public UserSession()
    {
        database = new Database();
        authorizationServer = new AuthorizationServer();
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Database getDatabase()
    {
        return database;
    }

    /**
     * Finds the given Username in database ArrayList
     * Checks user password against GUI input
     * If successful, loginView success is shown otherwise appropriate error messages are showed
     * @param username Username string from txtFieldUsername
     * @param password Password string from txtFieldPassword
     * @param authorization Database integer from comboBoxAuthorizationLevels
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
}
