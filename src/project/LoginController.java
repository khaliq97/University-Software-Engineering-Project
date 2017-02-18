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
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    Login login;

    @FXML
    private TextField txtFieldUserName;

    @FXML
    private TextField txtFieldPassword;

    @FXML
    private Button buttonLogin;

    @FXML
    private ComboBox<String> comboBoxAccess;

    private int selectedAccessLevel;

    public LoginController(Login login)
    {
        this.login = login;
        selectedAccessLevel = 1;
    }

    @FXML
    public void onLoginButtonClick()
    {
        login.login(txtFieldUserName.getText(), txtFieldPassword.getText(), selectedAccessLevel);
    }

    @FXML
    public void onComboBoxAction()
    {
        switch (comboBoxAccess.getSelectionModel().getSelectedItem())
        {
            case "Employee":
                selectedAccessLevel = 1;
                break;
            case "Reviewer":
                selectedAccessLevel = 2;
                break;
            case "HR Employee":
                selectedAccessLevel = 3;
                break;
            case "Manager":
                selectedAccessLevel = 4;
                break;
            case "Director":
                selectedAccessLevel = 5;
                break;

        }


    }

    public String getUsername()
    {
        return txtFieldUserName.getText();
    }

    public String getPassword()
    {
        return txtFieldPassword.getText();
    }

    public int getSelectedAccessLevel()
    {
        return selectedAccessLevel;
    }

    public void populateAccessComboBox()
    {
        List<String> accessListItems = new ArrayList<String>();
        accessListItems.add("Employee");
        accessListItems.add("Manager");
        accessListItems.add("Director");
        accessListItems.add("HR Employee");
        accessListItems.add("Reviewer");

        ObservableList observableList = FXCollections.observableList(accessListItems);
        comboBoxAccess.setItems(observableList);


    }
}
