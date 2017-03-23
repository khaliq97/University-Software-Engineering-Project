package project.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.Controllers.CreatePersonalDetailsController;
import project.Controllers.HomeController;
import project.Database.Personal_Detail.PersonalDetailController;

import java.io.IOException;

/**
 * Created by Osama Khaliq
 * Version (19/02/2016)
 * GUI class for CreatePersonalDetails
 */
public class CreatePersonalDetailsView {

    HomeView homeView;

    PersonalDetailController personalDetailController;

    private Parent root;
    private Stage stage;
    private FXMLLoader fxmlLoader;
    private Scene scene;

    CreatePersonalDetailsController createPersonalDetailsController;

    /**
     * Constructor for class
     * Passes in homeView
     * @param homeView homeView instance
     */
    public CreatePersonalDetailsView(HomeView homeView, PersonalDetailController personalDetailController)
    {
        this.homeView = homeView;
        this.personalDetailController = personalDetailController;
        fxmlLoader = new FXMLLoader(getClass().getResource("FXML/CreatePersonalDetails.fxml"));
        stage = new Stage();
        createPersonalDetailsController = new CreatePersonalDetailsController(this);

        fxmlLoader.setController(createPersonalDetailsController);
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


    /**
     * Returns homeView class instance
     * @return homeview
     */
    public HomeView getHomeView()
    {
        return homeView;
    }

    /**
     * Shows the Window
     */
    public void loadCreatePersonalDetailsView()
    {
        stage.show();
    }

    /**
     * Closes the window
     */
    public void closeCreatePersonalDetailsView()
    {
        stage.close();
    }
}
