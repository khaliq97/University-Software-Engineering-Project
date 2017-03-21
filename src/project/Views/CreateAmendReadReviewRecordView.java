package project.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.Controllers.CreateAmendReadReviewRecordController;
import project.Database.Review.ReviewController;

import java.io.IOException;

/**
 * Created by aman on 18/03/17.
 */
public class CreateAmendReadReviewRecordView {

        HomeView homeView;

        private Parent root;
        private Stage stage;
        private FXMLLoader fxmlLoader;
        private Scene scene;

        ReviewController reviewController;
        CreateAmendReadReviewRecordController createAmendReadReviewRecordController;

        public CreateAmendReadReviewRecordView(HomeView homeView, ReviewController reviewController)
        {
            this.homeView = homeView;
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

            scene = new Scene(root, 414, 583);
            stage.setTitle("Create Personal Details");
            stage.setResizable(false);
            stage.setScene(scene);
        }

        public void loadCreateReviewRecordView()
        {
            stage.show();
        }

        public void closeCreateAmendReadReviewRecordView()
        {
            stage.close();
        }
}
