package project;

import javafx.animation.StrokeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.*;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private TextField txtFieldUserName;

    @FXML
    private TextField txtFieldPassword;

    @FXML
    private Button buttonLogin;

    @FXML
    private ComboBox<String> comboBoxAccess;

    public Controller()
    {

    }

    @FXML
    public void onLoginButtonClick()
    {

    }

    public void populateAccessComboBox()
    {
        List<String> accessListItems = new ArrayList<String>();
        accessListItems.add("Employee");
        accessListItems.add("Director");
        accessListItems.add("HR Employee");
        accessListItems.add("Manager");

        ObservableList observableList = FXCollections.observableList(accessListItems);
        comboBoxAccess.setItems(observableList);

    }
}
