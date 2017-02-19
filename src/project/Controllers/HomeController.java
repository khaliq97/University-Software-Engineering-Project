package project.Controllers;

import javafx.fxml.FXML;
import project.Views.HomeView;
import project.Views.LoginView;

/**
 * Created by Osama Khaliq
 * HomeView window controller class
 * Responsible for control event handling
 */
public class HomeController {

    private LoginView loginView;
    private HomeView homeView;

    public HomeController(HomeView homeView, LoginView loginView)
    {
        this.homeView = homeView;
        this.loginView = loginView;
    }

    @FXML
    public void onLogoutButtonClick()
    {
        homeView.logout();
        homeView.closeHomeView();
        loginView.loadLoginView();

    }

}
