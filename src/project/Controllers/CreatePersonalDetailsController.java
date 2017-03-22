package project.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import project.Database.Personal_Detail.PersonalDetail;
import project.Database.Personal_Detail.PersonalDetailController;
import project.Views.CreatePersonalDetailsView;

/**
 * Created by Osama Khaliq
 * Version (03/03/2016)
 * CreatePersonalDetailVew Window controller Class
 * Responsible for CreatePersonalDetailVew window event handling
 * Creates a PersonalDetail object.
 */
public class CreatePersonalDetailsController {

    PersonalDetailController personalDetailController;
    CreatePersonalDetailsView createPersonalDetailsView;

    @FXML
    private TextField txtFieldUserName;

    @FXML
    private TextField txtFieldSurname;

    @FXML
    private TextField txtFieldName;

    @FXML
    private TextField txtFieldDateOfBirth;

    @FXML
    private TextField txtFieldAddress;

    @FXML
    private TextField txtFieldTownCity;

    @FXML
    private TextField txtFieldCounty;

    @FXML
    private TextField txtFieldPostcode;

    @FXML
    private TextField txtFieldTelephoneNumber;

    @FXML
    private TextField txtFieldMobileNumber;

    @FXML
    private TextField txtFieldEmergencyContact;

    @FXML
    private TextField txtFieldEmergencyContactNumber;


    /**
     * Constructor for class
     *
     * @param createPersonalDetailsView createPersonalDetailsView Window
     */
    public CreatePersonalDetailsController(CreatePersonalDetailsView createPersonalDetailsView, PersonalDetailController personalDetailController) {
        this.createPersonalDetailsView = createPersonalDetailsView;
        this.personalDetailController = personalDetailController;


    }

    /**
     * Event handler for buttonCreate Button control
     * Creates a new PersonalDetail object
     * Checks if a Personal Detail already exists for the User
     * Adds it to HRDatabase
     */
    @FXML
    public void onButtonCreateClick() {

        int result = personalDetailController.createPersonalDetail(txtFieldUserName.getText(), txtFieldSurname.getText(), txtFieldName.getText(), txtFieldDateOfBirth.getText(), txtFieldAddress.getText(),
                txtFieldTownCity.getText(), txtFieldCounty.getText(), txtFieldPostcode.getText(), txtFieldTelephoneNumber.getText(), txtFieldMobileNumber.getText(),
                txtFieldEmergencyContact.getText(), txtFieldEmergencyContactNumber.getText());

        if (result == 1){

            showSuccessfulPersonalDetailsCreationAlert();

            createPersonalDetailsView.closeCreatePersonalDetailsView();
        }else if(result == 0)
        {
            showPersonalDetailExistsAlert();
            createPersonalDetailsView.closeCreatePersonalDetailsView();
        }
    }

    /**
     * Shows Alert box for successful PersonalDetail creation
     */
    public void showSuccessfulPersonalDetailsCreationAlert()
    {

        Alert successfulPersonalDetails = new Alert(Alert.AlertType.INFORMATION);
        successfulPersonalDetails.setHeaderText("Personal Details created successfully for " + txtFieldUserName.getText());
        successfulPersonalDetails.show();
    }

    /**
     * Shows Alert Box if a Personal Detail already exists for a User
     */
    public void showPersonalDetailExistsAlert()
    {

        Alert personalDetailsExist = new Alert(Alert.AlertType.ERROR);
        personalDetailsExist.setHeaderText("Personal Details already exists for " + txtFieldUserName.getText());
        personalDetailsExist.show();
    }
}
