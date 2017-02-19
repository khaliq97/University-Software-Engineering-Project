package project;

/**
 * Created by Osama Khaliq
 * Version (19/02/2016)
 * Responsible for authorizing the User and logs them in
 * Takes a User object and inputted authorization level
 */
public class AuthorizationServer {

    LoginView loginView;


    /*
    Authorization Levels

    Employee : 1
    HR Employee : 3
    Director : 5
    Manager: 4
    Reviewer: 2
     */

    public AuthorizationServer(LoginView loginView)
    {
        this.loginView = loginView;
    }

    public boolean authUser(User user, int authorization)
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
