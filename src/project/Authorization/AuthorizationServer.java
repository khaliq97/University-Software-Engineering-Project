package project.Authorization;

import project.User.User;
import project.Views.LoginView;

/**
 * Created by Osama Khaliq
 * Version (19/02/2016)
 * Responsible for authorizing the User and logs them in
 * Takes a User object and inputted authorization level
 */
public class AuthorizationServer {

    /*
    Authorization Levels reference

    Employee : 1
    Reviewer: 2
    HR Employee : 3
    Director : 5
    Manager: 4
     */

    private LoginView loginView;



    /**
     * Class constructor
     * @param loginView LoginView instance
     */
    public AuthorizationServer(LoginView loginView)
    {
        this.loginView = loginView;
    }

    /**
     * Checks authorization level against the inputted authorization level
     * If autorization level matches against input or is higher then returns true
     * @param user User to authorise
     * @param authorization Authorization level to check against
     * @return boolean
     */
    public boolean authorizationCheck(User user, int authorization)
    {
        if(user.getAuthorization() == authorization || user.getAuthorization() > authorization)
        {
            user.setLoggedIn(true);
            return true;
        }else
        {
            return false;
        }
    }





































}
