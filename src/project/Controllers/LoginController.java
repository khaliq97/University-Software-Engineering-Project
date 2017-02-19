package project.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.control.ComboBox;
import project.Views.LoginView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osama Khaliq
 * Version (17/02/2016)
 * LoginView Window controller Class
 * Responsible for LoginView window event handling
 * Shows Alert boxes
 */

public class LoginController {

    private LoginView loginView;

    @FXML
    private TextField txtFieldUserName;

    @FXML
    private TextField txtFieldPassword;

    @FXML
    private Button buttonLogin;


    @FXML
    private ComboBox<String> comboBoxAuthorizationLevels;

    private int selectedAuthorizationLevel;

    private String selectedAuthorizationString;

    /**
     * Constructor for LoginController
     * selectedAuthorizationLevel is default set to 1
     * @param loginView LoginView window
     */
    public LoginController(LoginView loginView)
    {
        this.loginView = loginView;
        selectedAuthorizationLevel = 1;
        selectedAuthorizationString = "Employee";
    }

    /**
     * Executes "login" function from LoginView
     * Passes values from Username, Password field and Authorisation
     */
    @FXML
    public void onLoginButtonClick()
    {
        if(loginView.login(txtFieldUserName.getText(), txtFieldPassword.getText(), selectedAuthorizationLevel))
        {
            txtFieldUserName.clear();
            txtFieldPassword.clear();
            selectedAuthorizationLevel = 1;

            //Selects first item in the ComboBox
            comboBoxAuthorizationLevels.getSelectionModel().selectFirst();
        }
    }

    /**
     * Executes on selected ComboBox item change
     * Sets selectedAuthorizationLevel in accordance with item selected
     */
    @FXML
    public void onComboBoxAction()
    {
        switch (comboBoxAuthorizationLevels.getSelectionModel().getSelectedItem())
        {
            //Converts the String in ComboBox to the corresponding authorization number
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

        selectedAuthorizationString = comboBoxAuthorizationLevels.getSelectionModel().getSelectedItem();

    }

    /**
     * Return selectedAuthorizationString
     * @return selectedAuthorizationString
     */
    public String getSelectedAuthorizationString()
    {
        return selectedAuthorizationString;
    }


    /**
     * Returns txtFieldPassword control
     * @return txtFieldPassword
     */
    public TextField getTxtFieldPassword()
    {
        return txtFieldPassword;
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
     * Shows Alert box for missing JSON file
     */
    public void showMissingJSONFileAlert(String jsonFilePath)
    {
        Alert incorrectUsername = new Alert(Alert.AlertType.ERROR);
        incorrectUsername.setHeaderText(jsonFilePath + " not found, application exiting");
        incorrectUsername.show();
    }

    /**
     * Adds authorization levels to comboBoxAccess control
     */
    public int populateAccessComboBox()
    {
        List<String> accessListItems = new ArrayList<String>();
        accessListItems.add("Employee");
        accessListItems.add("HR Employee");
        accessListItems.add("Reviewer");
        accessListItems.add("Director");
        accessListItems.add("Manager");

        ObservableList observableList = FXCollections.observableList(accessListItems);
        comboBoxAuthorizationLevels.setItems(observableList);

        return comboBoxAuthorizationLevels.getItems().size();

    }
}
