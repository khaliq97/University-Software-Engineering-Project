package project.Database.User_Database;

import project.Database.User.User;

/**
 * Created by Osama Khaliq
 * Responsible for authorizing the User and logs them in
 * Takes a User object and inputted authorization level
 *
 * @Author Osama Khaliq
 * @version (25/03/2017)
 */
public class AuthorizationServer {

    /*
    Database Levels reference

    Employee : 1
    Reviewer: 2
    HR Employee : 3
    Director : 5
    Manager: 4
     */

    /**
     * Class constructor
     * Empty
     */
    public AuthorizationServer()
    {

    }

    /**
     * Checks authorization level against the inputted authorization level
     * If autorization level matches against input or is higher then returns true
     * @param user User to authorise
     * @param authorization Database level to check against
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