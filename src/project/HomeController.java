package project;

import javafx.fxml.FXML;

/**
 * Created by osamakhaliq on 18/02/17.
 */
public class HomeController {

    LoginView loginView;
    HomeView homeView;

    public HomeController(HomeView homeView, LoginView loginView)
    {
        this.homeView = homeView;
        this.loginView = loginView;
    }

    @FXML
    public void onLogoutButtonClick()
    {
        homeView.logout();
        homeView.close();
        loginView.show();

    }

}
