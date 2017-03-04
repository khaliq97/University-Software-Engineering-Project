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

    /**
     * Methods checks authorization level of user
     * Determines what buttons to enable and disable based on level
     * @param auth user autorization level
     */
    public void checkAuthorization(int auth)
    {


        if(auth == 3 || auth == 5) {
            buttonCreatePersonalDetail.setDisable(false);;
            homeView.getReadAmendPersonalDetailsView().getReadAmendPersonalDetailsController().getButtonView().setDisable(false);
            homeView.getReadAmendPersonalDetailsView().getReadAmendPersonalDetailsController().getTxtFieldUserName().setEditable(true);

        }else
        {
            buttonCreatePersonalDetail.setDisable(true);
            homeView.getReadAmendPersonalDetailsView().getReadAmendPersonalDetailsController().getButtonView().setDisable(true);
            homeView.getReadAmendPersonalDetailsView().getReadAmendPersonalDetailsController().getTxtFieldUserName().setEditable(false);
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

    /**
     * Shows the CreatePersonalDetailsView window.
     */
    @FXML
    public void onButtonCreatePersonalDetailClick()
    {
        homeView.getCreatePersonalDetailsView().loadCreatePersonalDetailsView();
    }


    /**
     * Shows the ReadAmendPersonalDetailsController window.
     * ReadAmendPersonalDetailsController is set to Amend mode
     * Passes username of logged in user.
     */
    @FXML
    public void onButtonAmendPersonalDetailClick()
    {
        homeView.getReadAmendPersonalDetailsView().loadAmendPersonalDetailsView();
        homeView.getReadAmendPersonalDetailsView().getReadAmendPersonalDetailsController().checkMode();
        homeView.getReadAmendPersonalDetailsView().getReadAmendPersonalDetailsController().loadPersonalDetails(homeView.getUserSession().getUser().getUsername());
    }

    /**
     * Shows the ReadAmendPersonalDetailsController window.
     * ReadAmendPersonalDetailsController is set to Read mode
     * Passes username of logged in user.
     */
    @FXML
    public void onButtonReadPersonalDetailClick()
    {
        homeView.getReadAmendPersonalDetailsView().loadReadPersonalDetailsView();
        homeView.getReadAmendPersonalDetailsView().getReadAmendPersonalDetailsController().checkMode();
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
