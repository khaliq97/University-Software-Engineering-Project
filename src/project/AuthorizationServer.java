package project;

/**
 * Created by osamakhaliq on 18/02/17.
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
