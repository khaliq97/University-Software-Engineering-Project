package project;

import javafx.animation.StrokeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.*;
import javafx.scene.control.ComboBox;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osama Khaliq
 * Version (17/02/2016)
 * Login Window controller Class
 * Responsible for button and ComboBox event handling
 * Shows Alert boxes
 */

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

    private int selectedAuthorizationLevel;

    /**
     * Constructor for LoginController
     * selectedAuthorizationLevel is default set to 1
     * @param login
     */
    public LoginController(Login login)
    {
        this.login = login;
        selectedAuthorizationLevel = 1;
    }

    /**
     * Executes "login" function from Login
     * Passes values from Username, Password field and Authorisation
     */
    @FXML
    public void onLoginButtonClick()
    {
        login.login(txtFieldUserName.getText(), txtFieldPassword.getText(), selectedAuthorizationLevel);
    }

    /**
     * Executes on selected ComboBox item change
     * Sets selectedAuthorizationLevel in accordance with item selected
     */
    @FXML
    public void onComboBoxAction()
    {
        switch (comboBoxAccess.getSelectionModel().getSelectedItem())
        {
            case "Employee":
                selectedAuthorizationLevel = 1;
                break;
            case "Reviewer":
                selectedAuthorizationLevel = 2;
                break;
            case "HR Employee":
                selectedAuthorizationLevel = 3;
                break;
            case "Manager":
                selectedAuthorizationLevel = 4;
                break;
            case "Director":
                selectedAuthorizationLevel = 5;
                break;

        }


    }

    /**
     * Returns selectedAuthorizationLevel
     * @return selectedAuthorizationLevel
     */
    public int getSelectedAccessLevel()
    {
        return selectedAuthorizationLevel;
    }


    /**
     * Displays Alert box for message "incorrect Username or Password"
     */
    public void showIncorrectUsernameOrPasswordAlert()
    {
        Alert incorrectUsername = new Alert(Alert.AlertType.ERROR);
        incorrectUsername.setHeaderText("Incorrect Username or Password");
        incorrectUsername.show();
    }

    /**
     * Shows Alert box for Authorization Failure
     */
    public void showAuthorizationFailureAlert()
    {
        Alert incorrectUsername = new Alert(Alert.AlertType.ERROR);
        incorrectUsername.setHeaderText("Authorization failure");
        incorrectUsername.show();
    }

    /**
     * Shows Alert box for Login Success
     */
    public void showLoginSuccess()
    {
        Alert incorrectUsername = new Alert(Alert.AlertType.INFORMATION);
        incorrectUsername.setHeaderText("Login Success");
        incorrectUsername.show();
    }

    /**
     * Adds authorization levels to comboBoxAccess control
     */
    public void populateAccessComboBox()
    {
        List<String> accessListItems = new ArrayList<String>();
        accessListItems.add("Employee");
        accessListItems.add("HR Employee");
        accessListItems.add("Reviewer");
        accessListItems.add("Director");
        accessListItems.add("Manager");

        ObservableList observableList = FXCollections.observableList(accessListItems);
        comboBoxAccess.setItems(observableList);


    }
}
