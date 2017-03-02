package project.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import project.Views.HomeView;
import project.Views.LoginView;

/**
 * Created by Osama Khaliq
 * HomeView window controller class
 * Responsible for HomeView window control event handling
 */
public class HomeController {

    private LoginView loginView;
    private HomeView homeView;

    @FXML
    private Label labelWelcome;

    @FXML
    private Button buttonCreatePersonalDetail;

    /**
     * Class constructor
     * @param homeView HomeView instance
     * @param loginView LoginView instance
     */
    public HomeController(HomeView homeView, LoginView loginView)
    {
        this.homeView = homeView;
        this.loginView = loginView;
    }

    /**
     * Event handler for when buttonLogout is clicked
     */
    @FXML
    public void onLogoutButtonClick()
    {
        homeView.logout();
        homeView.closeHomePageView();
        loginView.loadLoginView();

    }

    @FXML
    public void onButtonCreatePersonalDetailClick()
    {
        homeView.getCreatePersonalDetailsView().loadCreatePersonalDetailsView();
    }

    /**
     * Sets the labelWelcome text
     * @param value Text to set
     */
    public void setLabelWelcome(String value)
    {
        labelWelcome.setText(value);
    }

}
