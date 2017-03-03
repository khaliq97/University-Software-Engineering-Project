package project.Database;

import project.User.User;
import project.Views.HomeView;

/**
 * Created by osamakhaliq on 03/03/17.
 */
public class UserSession {

    private Database database;
    private AuthorizationServer authorizationServer;


    public UserSession(Database database, AuthorizationServer authorizationServer)
    {
        this.database = database;
        this.authorizationServer = authorizationServer;
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
                    primaryStage.close();
                    HomeView homeView = new HomeView(this, potentialUser);
                    homeView.loadHomePageView();

                    return "SUCCESS";

                }else
                {
                    loginController.showAuthorizationFailureAlert();
                    return "AUTH FAILURE";
                }

            }else
            {
                loginController.loadForgotPasswordView();
                loginController.getTxtFieldPassword().clear();
                return "USER, PASS FAILURE";

            }
        }else
        {
            loginController.loadForgotPasswordView();
            loginController.getTxtFieldPassword().clear();
            return "USER, PASS FAILURE";
        }


    }
}
