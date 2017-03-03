package project.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.Controllers.ReadAmendPersonalDetailsController;

import java.io.IOException;

/**
 * Created by osamakhaliq on 02/03/17.
 */
public class ReadAmendPersonalDetailsView {
    HomeView homeView;

    private Parent root;
    private Stage stage;
    private FXMLLoader fxmlLoader;
    private Scene scene;

    private boolean amendMode;

    ReadAmendPersonalDetailsController readAmendPersonalDetailsController;

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

    public HomeView getHomeView()
    {
        return homeView;
    }

    public Stage getStage()
    {
        return stage;
    }

    public boolean isAmendMode()
    {
        return amendMode;
    }

    public void setAmendMode(boolean amendMode)
    {
        this.amendMode = amendMode;
    }


    public ReadAmendPersonalDetailsController getReadAmendPersonalDetailsController()
    {
        return readAmendPersonalDetailsController;
    }

    public void loadReadPersonalDetailsView()
    {
        amendMode = false;
        stage.show();
    }

    public void loadAmendPersonalDetailsView()
    {
        amendMode = true;
        stage.show();
    }

    public void closeReadPersonalDetailsView()
    {
        stage.close();
    }
}
