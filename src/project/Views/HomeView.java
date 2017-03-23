package project.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.Controllers.HomeController;
import project.Database.Personal_Detail.PersonalDetailController;
import project.Database.Review.ReviewController;
import project.Database.User_Database.UserSession;
import project.Database.HR_Database.HRDatabaseController;

import java.io.IOException;

/**
 * Created by Osama Khaliq
 * Version (19/02/2016)
 * GUI class for HomeView
 * Window is shown when the user successfully logs in
 */
public class HomeView
{
    private LoginView loginView;

    private UserSession userSession;

    public PersonalDetailController getPersonalDetailController() {
        return personalDetailController;
    }

    private PersonalDetailController personalDetailController;

    private CreatePersonalDetailsView createPersonalDetailsView;

    private ReadAmendPersonalDetailsView readAmendPersonalDetailsView;

    private ReviewController reviewController;

    private CreateAmendReadReviewRecordView createAmendReadReviewRecordView;


    private HRDatabaseController hrDatabaseController;

    private Parent root;
    private Stage stage;
    private FXMLLoader fxmlLoader;
    private Scene scene;
    private HomeController homeController;



    /**
     * Constructor for HomeView class
     * Passes in loginView and User
     * @param loginView LoginView instance
     */
    public HomeView(LoginView loginView, UserSession userSession)
    {
        fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Home.fxml"));
        stage = new Stage();
        homeController = new HomeController(this, loginView);
        hrDatabaseController = new HRDatabaseController();

        this.userSession = userSession;

        personalDetailController = new PersonalDetailController(hrDatabaseController);
        createPersonalDetailsView = new CreatePersonalDetailsView(this, personalDetailController);
        readAmendPersonalDetailsView = new ReadAmendPersonalDetailsView(this, personalDetailController);

        reviewController = new ReviewController(hrDatabaseController);
        createAmendReadReviewRecordView = new CreateAmendReadReviewRecordView(this, reviewController);
//        createAmendReadReviewRecordView = new CreateAmendReadReviewRecordView(this, reviewController);

        fxmlLoader.setController(homeController);
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root, 745, 528);
        stage.setTitle("Home");
        stage.setScene(scene);

        this.loginView = loginView;

        initialize();

    }

    /**
     * Initializes controls in Class
     * Sets the text of the labelWelcome control
     */
    public void initialize()
    {
        homeController.setLabelWelcomeText(("User: " + userSession.getUser().getUsername() + ", you're are logged in as " + loginView.getLoginController().getSelectedAuthorizationString()));
        readAmendPersonalDetailsView.getReadAmendPersonalDetailsController().getTxtFieldUserName().setText(userSession.getUser().getUsername());
    }

    public HomeController getHomeController()
    {
        return homeController;
    }
    
    public UserSession getUserSession()
    {
        return userSession;
    }


    public CreatePersonalDetailsView getCreatePersonalDetailsView() {
        return createPersonalDetailsView;
    }

    public ReadAmendPersonalDetailsView getReadAmendPersonalDetailsView() {
        return readAmendPersonalDetailsView;
    }

    public HRDatabaseController getHrDatabaseController()
    {
        return hrDatabaseController;
    }

    public CreateAmendReadReviewRecordView getCreateAmendReadReviewRecordView() {
        return createAmendReadReviewRecordView;
    }

    /**
     * Loads the HomeView window
     */
    public void loadHomeView()
    {
        stage.show();
    }

    /**
     * Loads the HomeView window
     */
    public void closeHomeView()
    {
        stage.close();
    }
}
