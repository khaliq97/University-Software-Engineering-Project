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
 * GUI class for HomeView
 * Window is shown when the user successfully logs in
 *
 * @Author Osama Khaliq
 * @version (25/03/2017)
 */
public class HomeView
{
    private LoginView loginView;

    private UserSession userSession;

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
     * Sets up and initializes the window
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

    /**
     * Returns personalDetailController class
     * @return personalDetailController
     */
    public PersonalDetailController getPersonalDetailController() {
        return personalDetailController;
    }

    /**
     * Returns homeController class
     * @return homeController
     */
    public HomeController getHomeController()
    {
        return homeController;
    }

    /**
     * Returns UserSession class
     * @return userSession
     */
    public UserSession getUserSession()
    {
        return userSession;
    }

    /**
     * Returns createPersonalDetailsView class
     * @return createPersonalDetailsView
     */
    public CreatePersonalDetailsView getCreatePersonalDetailsView() {
        return createPersonalDetailsView;
    }

    /**
     * Returns readAmendPersonalDetailsView class
     * @return readAmendPersonalDetailsView
     */
    public ReadAmendPersonalDetailsView getReadAmendPersonalDetailsView() {
        return readAmendPersonalDetailsView;
    }

    /**
     * Returns hrDatabaseController class
     * @return
     */
    public HRDatabaseController getHrDatabaseController()
    {
        return hrDatabaseController;
    }

    /**
     * Returns createAmendReadReviewRecordView class
     * @return createAmendReadReviewRecordView
     */
    public CreateAmendReadReviewRecordView getCreateAmendReadReviewRecordView() {
        return createAmendReadReviewRecordView;
    }
}
