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
 * GUI class for CreatePersonalDetails
 *
 * @Author Osama Khaliq
 * @version (25/03/2017)
 */
public class CreatePersonalDetailsView {

    private HomeView homeView;

    private PersonalDetailController personalDetailController;

    private Parent root;
    private Stage stage;
    private FXMLLoader fxmlLoader;
    private Scene scene;

    private CreatePersonalDetailsController createPersonalDetailsController;

    /**
     * Constructor for class
     * Sets up and initializes the window
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
