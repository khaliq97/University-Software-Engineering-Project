package project.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.Controllers.ReadAmendPersonalDetailsController;

import java.io.IOException;

/**
 * Created by Osama Khaliq
 * Version (19/02/2016)
 * GUI class for ReadAmendPersonalDetails
 */
public class ReadAmendPersonalDetailsView {
    HomeView homeView;

    private Parent root;
    private Stage stage;
    private FXMLLoader fxmlLoader;
    private Scene scene;

    private boolean amendMode;

    ReadAmendPersonalDetailsController readAmendPersonalDetailsController;

    /**
     * Constructor for class
     * Passes in homeView
     * @param homeView homeView instance
     */
    public ReadAmendPersonalDetailsView(HomeView homeView)
    {
        this.homeView = homeView;
        fxmlLoader = new FXMLLoader(getClass().getResource("FXML/ReadPersonalDetails.fxml"));
        stage = new Stage();
        readAmendPersonalDetailsController = new ReadAmendPersonalDetailsController(this);
        amendMode = false;

        fxmlLoader.setController(readAmendPersonalDetailsController);
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root, 414, 568);
        stage.setTitle("Read Personal Details");
        stage.setResizable(false);
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
    public void closeReadPersonalDetailsView()
    {
        stage.close();
    }
}
