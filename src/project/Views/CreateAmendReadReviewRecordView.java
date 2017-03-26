package project.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.Controllers.CreateAmendReadReviewRecordController;
import project.Database.Review.ReviewController;

import java.io.IOException;

/**
 * Created by Aman Gohel on 18/03/17.
 *
 * GUI for CreateAmendReadReviewRecord
 * Contains methods to to change the mode of the window, create, amend or read
 *
 * @Author Aman Gohel
 * @version (25/03/2017)
 */
public class CreateAmendReadReviewRecordView {

    private Parent root;
    private Stage stage;
    private FXMLLoader fxmlLoader;
    private Scene scene;

    private ReviewController reviewController;


    private CreateAmendReadReviewRecordController createAmendReadReviewRecordController;

    /**
     * Class constructor
     * Sets up and initializes the window
     * @param homeView Instance of HomeView
     * @param reviewController Instance of ReviewController
     */
    public CreateAmendReadReviewRecordView(HomeView homeView, ReviewController reviewController)
    {
        fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Review.fxml"));
        stage = new Stage();
        this.reviewController = reviewController;
        createAmendReadReviewRecordController = new CreateAmendReadReviewRecordController(this);

         fxmlLoader.setController(createAmendReadReviewRecordController);
         try {
             root = fxmlLoader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }

        scene = new Scene(root, 600, 882);
        stage.setTitle("Create Personal Details");
        //stage.setResizable(false);
        stage.setScene(scene);

        initialize();
    }

    /**
     * Populates the comboBoxRecommendation control
     */
    public void initialize()
    {
        createAmendReadReviewRecordController.populateComboBoxRecommendation();

    }

    /**
     * Returns ReviewController class instance
     * @return reviewController
     */
    public ReviewController getReviewController() {
        return reviewController;
    }


    /**
     * Loads the CreateAmendReadReviewRecordView in create mode
     */
    public void loadCreateReviewRecordView()
    {
        createAmendReadReviewRecordController.createMode();
        stage.show();
    }

    /**
     * Loads the CreateAmendReadReviewRecordView in read mode
     */
    public void loadReadReviewRecordView()
    {
        createAmendReadReviewRecordController.readMode();
        stage.show();
    }

    /**
     * Loads the CreateAmendReadReviewRecordView in amend mode
     */
    public void loadAmendReviewRecordView()
    {
        createAmendReadReviewRecordController.amendMode();
        stage.show();
    }

    /**
     * Closes the window
     */
    public void closeCreateAmendReadReviewRecordView()
        {
            stage.close();
        }
}
