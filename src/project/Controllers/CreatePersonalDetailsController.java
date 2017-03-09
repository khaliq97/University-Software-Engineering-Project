package project.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import project.Database.User.PersonalDetail;
import project.Views.CreatePersonalDetailsView;

/**
 * Created by Osama Khaliq
 * Version (03/03/2016)
 * CreatePersonalDetailVew Window controller Class
 * Responsible for CreatePersonalDetailVew window event handling
 * Creates a PersonalDetail object.
 */
public class CreatePersonalDetailsController {

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
    public CreatePersonalDetailsController(CreatePersonalDetailsView createPersonalDetailsView) {
        this.createPersonalDetailsView = createPersonalDetailsView;

    }

    /**
     * Event handler for buttonCreate Button control
     * Creates a new PersonalDetail object
     * Checks if a Personal Detail already exists for the User
     * Adds it to HRDatabase
     */
    @FXML
    public void onButtonCreateClick() {

        boolean personalDetailExists = false;
        boolean userExists = false;
        PersonalDetail personalDetailToAdd = null;
        for (PersonalDetail personalDetail : createPersonalDetailsView.getHomeView().getHrDatabaseController().getHrDatabase().getPersonalDetails()) {

                if (!personalDetail.getUserName().equals(txtFieldUserName.getText()))
                {
                    personalDetailExists = false;
                }else
                {
                    personalDetailExists = true;
                }
        }

        if(!personalDetailExists)
        {
            PersonalDetail newPersonalDetail = new PersonalDetail();

            newPersonalDetail.setUserName(txtFieldUserName.getText());
            newPersonalDetail.setSurname(txtFieldSurname.getText());
            newPersonalDetail.setName(txtFieldName.getText());
            newPersonalDetail.setDOB(txtFieldDateOfBirth.getText());
            newPersonalDetail.setAddress(txtFieldAddress.getText());
            newPersonalDetail.setTownCity(txtFieldTownCity.getText());
            newPersonalDetail.setCounty(txtFieldCounty.getText());
            newPersonalDetail.setPostcode(txtFieldPostcode.getText());
            newPersonalDetail.setTelephoneNumber(txtFieldTelephoneNumber.getText());
            newPersonalDetail.setMobileNumber(txtFieldMobileNumber.getText());
            newPersonalDetail.setEmergencyContact(txtFieldEmergencyContact.getText());
            newPersonalDetail.setEmergencyContactNumber(txtFieldEmergencyContactNumber.getText());

            createPersonalDetailsView.getHomeView().getHrDatabaseController().createPersonalDetail(newPersonalDetail);

            showSuccessfulPersonalDetailsCreationAlert();
            createPersonalDetailsView.closeCreatePersonalDetailsView();
        }else
        {
            showPersonalDetailExistsAlert();
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
