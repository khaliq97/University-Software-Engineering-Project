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
 *
 * @Author Osama Khaliq
 * @version (25/03/2017)
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

    @FXML
    private Button buttonCreateReviewRecord;

    @FXML
    private Button buttonAmendReviewRecord;

    @FXML
    private Button buttonReadReviewRecord;

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
     * @param auth user authorization level
     */
    public void checkAuthorization(int auth)
    {


        if(auth == 3 || auth == 5) {
            if(auth == 3)
            {
                buttonCreateReviewRecord.setDisable(false);
                buttonAmendReviewRecord.setDisable(false);
                buttonReadReviewRecord.setDisable(false);
            }else
            {
                buttonCreateReviewRecord.setDisable(true);
                buttonAmendReviewRecord.setDisable(true);
                buttonReadReviewRecord.setDisable(true);
            }
            buttonCreatePersonalDetail.setDisable(false);
            buttonAmendPersonalDetail.setDisable(false);
            homeView.getReadAmendPersonalDetailsView().getReadAmendPersonalDetailsController().getButtonLoadPersonalDetail().setDisable(false);
            homeView.getReadAmendPersonalDetailsView().getReadAmendPersonalDetailsController().getTxtFieldUserName().setEditable(true);

        }else
        {
            buttonCreateReviewRecord.setDisable(true);
            buttonAmendReviewRecord.setDisable(true);
            buttonReadReviewRecord.setDisable(true);

            buttonCreatePersonalDetail.setDisable(true);
            buttonAmendPersonalDetail.setDisable(true);
            homeView.getReadAmendPersonalDetailsView().getReadAmendPersonalDetailsController().getButtonLoadPersonalDetail().setDisable(true);
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
        homeView.closeHomeView();
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
    }

    /**
     * buttonCreateReviewRecord onMouseClick event handler
     * Loads the CreateAmendReadReviewRecordView in create mode
     */
    @FXML
    public void onButtonCreateReviewRecordClick()
    {
        homeView.getCreateAmendReadReviewRecordView().loadCreateReviewRecordView();
    }

    /**
     * buttonReadReviewRecordClick onMouseClick event handler
     * Loads the CreateAmendReadReviewRecordView in read mode
     */
    @FXML
    public void onButtonReadReviewRecordClick()
    {
        homeView.getCreateAmendReadReviewRecordView().loadReadReviewRecordView();
    }


    /**
     * buttonAmendRecordClick onMouseClick event handler
     * Loads the CreateAmendReadReviewRecordView in amend mode
     */
    @FXML
    public void onButtonAmendRecordClick()
    {
        homeView.getCreateAmendReadReviewRecordView().loadAmendReviewRecordView();
    }


    /**
     * Sets the labelWelcome text
     * @param value Text to set
     */
    public void setLabelWelcomeText(String value)
    {
        labelWelcome.setText(value);
    }

}
