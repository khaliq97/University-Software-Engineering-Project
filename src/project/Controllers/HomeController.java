package project.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

    @FXML
    private Label labelWelcome;

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

    public void setLabelWelcome(String value)
    {
        labelWelcome.setText(value);
    }

}
