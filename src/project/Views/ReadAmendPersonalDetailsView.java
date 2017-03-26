package project.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.Controllers.ReadAmendPersonalDetailsController;
import project.Database.Personal_Detail.PersonalDetail;
import project.Database.Personal_Detail.PersonalDetailController;

import java.io.IOException;

/**
 * Created by Osama Khaliq
 * GUI class for ReadAmendPersonalDetails
 *
 * @Author Osama Khaliq
 * @version (25/03/2017)
 */
public class ReadAmendPersonalDetailsView {
    private HomeView homeView;

    private Parent root;
    private Stage stage;
    private FXMLLoader fxmlLoader;
    private Scene scene;

    private boolean amendMode;

    private PersonalDetailController personalDetailController;
    private ReadAmendPersonalDetailsController readAmendPersonalDetailsController;

    /**
     * Constructor for class
     * Passes in homeView
     * @param homeView homeView instance
     */
    public ReadAmendPersonalDetailsView(HomeView homeView, PersonalDetailController personalDetailController)
    {
        this.homeView = homeView;
        this.personalDetailController = personalDetailController;
        fxmlLoader = new FXMLLoader(getClass().getResource("FXML/ReadPersonalDetails.fxml"));
        stage = new Stage();
        readAmendPersonalDetailsController = new ReadAmendPersonalDetailsController(this, personalDetailController);
        amendMode = false;

        fxmlLoader.setController(readAmendPersonalDetailsController);
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root, 414, 603);
        stage.setTitle("Read Personal Details");
        //stage.setResizable(false);
        stage.setScene(scene);


    }

    /**
     * Returns homeView class instance
     * @return homeView class
     */
    public HomeView getHomeView()
    {
        return homeView;
    }

    /**
     * Returns stage
     * @return stage
     */
    public Stage getStage()
    {
        return stage;
    }

    /**
     * Returns isAmendMode boolean
     * @return amendMode
     */
    public boolean isAmendMode()
    {
        return amendMode;
    }

    /**
     * Sets isAmendMode boolean
     * @param amendMode boolean to set
     */
    public void setAmendMode(boolean amendMode)
    {
        this.amendMode = amendMode;
    }

    /**
     * Returns readAmendPersonalDetailsController class instance
     * @return readAmendPersonalDetailsController
     */
    public ReadAmendPersonalDetailsController getReadAmendPersonalDetailsController()
    {
        return readAmendPersonalDetailsController;
    }

    /**
     * Loads the ReadPersonalDetailsView with isAmendMode set to false
     */
    public void loadReadPersonalDetailsView()
    {
        amendMode = false;
        readAmendPersonalDetailsController.getTxtFieldUserName().setText(homeView.getUserSession().getUser().getUsername());
        readAmendPersonalDetailsController.readPersonalDetail();
        stage.show();
    }

    /**
     * Loads the AmendPersonalDetailsView with isAmendMode set to true
     */
    public void loadAmendPersonalDetailsView()
    {
        amendMode = true;
        stage.show();
    }

    /**
     * Closes window
     */
    public void closeReadAmendPersonalDetailsView()
    {
        stage.close();
    }
}
