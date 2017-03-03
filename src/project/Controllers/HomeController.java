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

    @FXML
    private Button buttonAmendPersonalDetail;

    @FXML
    private Button buttonReadPersonalDetail;

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

    public void checkAuthorization(int auth)
    {
        buttonCreatePersonalDetail.setDisable(false);
        buttonAmendPersonalDetail.setDisable(false);

        if(auth == 1)
        {
            buttonCreatePersonalDetail.setDisable(true);
            buttonAmendPersonalDetail.setDisable(true);
        }else if(auth > 1)
        {
            buttonCreatePersonalDetail.setDisable(false);
            buttonAmendPersonalDetail.setDisable(false);
        }
    }

    /**
     * Event handler for when buttonLogout is clicked
     */
    @FXML
    public void onLogoutButtonClick()
    {
        homeView.getUserSession().logout();
        homeView.closeHomePageView();
        loginView.loadLoginView();

    }

    @FXML
    public void onButtonCreatePersonalDetailClick()
    {
        homeView.getCreatePersonalDetailsView().loadCreatePersonalDetailsView();
    }

    @FXML
    public void onButtonAmendPersonalDetailClick()
    {
        homeView.getReadAmendPersonalDetailsView().loadAmendPersonalDetailsView();
        homeView.getReadAmendPersonalDetailsView().getReadAmendPersonalDetailsController().loadPersonalDetails(homeView.getUserSession().getUser().getUsername());
    }

    @FXML
    public void onButtonReadPersonalDetailClick()
    {
        homeView.getReadAmendPersonalDetailsView().loadReadPersonalDetailsView();
        homeView.getReadAmendPersonalDetailsView().getReadAmendPersonalDetailsController().loadPersonalDetails(homeView.getUserSession().getUser().getUsername());
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
