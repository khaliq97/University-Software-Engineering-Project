package project.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.Controllers.CreatePersonalDetailsController;
import project.Controllers.HomeController;

import java.io.IOException;

/**
 * Created by osamakhaliq on 02/03/17.
 */
public class CreatePersonalDetailsView {

    HomeView homeView;

    private Parent root;
    private Stage stage;
    private FXMLLoader fxmlLoader;
    private Scene scene;

    CreatePersonalDetailsController createPersonalDetailsController;

    public CreatePersonalDetailsView(HomeView homeView)
    {
        this.homeView = homeView;
        fxmlLoader = new FXMLLoader(getClass().getResource("FXML/CreatePersonalDetails.fxml"));
        stage = new Stage();
        createPersonalDetailsController = new CreatePersonalDetailsController(this);

        fxmlLoader.setController(createPersonalDetailsController);
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root, 414, 519);
        stage.setTitle("Create Personal Details");
        stage.setResizable(false);
        stage.setScene(scene);
    }


    public HomeView getHomeView()
    {
        return homeView;
    }

    public void loadCreatePersonalDetailsView()
    {
        stage.show();
    }

    public void closeCreatePersonalDetailsView()
    {
        stage.close();
    }
}
