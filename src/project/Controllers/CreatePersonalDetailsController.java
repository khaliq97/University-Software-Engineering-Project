package project.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import project.PersonalDetail;
import project.Views.CreatePersonalDetailsView;

/**
 * Created by osamakhaliq on 02/03/17.
 */
public class CreatePersonalDetailsController {

    CreatePersonalDetailsView createPersonalDetailsView;

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




    public CreatePersonalDetailsController(CreatePersonalDetailsView createPersonalDetailsView)
    {
        this.createPersonalDetailsView = createPersonalDetailsView;
    }

    @FXML
    public void onButtonCreateClick()
    {
        PersonalDetail newPersonalDetail = new PersonalDetail();

        newPersonalDetail.setSurname(txtFieldSurname.getText());
        newPersonalDetail.setName(txtFieldName.getText());
        newPersonalDetail.setDOB(txtFieldDateOfBirth.getText());
        newPersonalDetail.setAddress(txtFieldAddress.getText());
        newPersonalDetail.setTownCity(txtFieldAddress.getText());
        newPersonalDetail.setCounty(txtFieldCounty.getText());
        newPersonalDetail.setPostcode(txtFieldPostcode.getText());
        newPersonalDetail.setTelephoneNumber(Integer.parseInt(txtFieldTelephoneNumber.getText()));
        newPersonalDetail.setMobileNumber(Integer.parseInt(txtFieldMobileNumber.getText()));
        newPersonalDetail.setEmergencyContact(txtFieldEmergencyContact.getText());
        newPersonalDetail.setEmergencyContactNumber(Integer.parseInt(txtFieldEmergencyContactNumber.getText()));

        createPersonalDetailsView.getHomeView().getHrDatabaseController().getHrDatabase().createPersonalDetail(newPersonalDetail);
        showSuccessfulPersonalDetailsCreationAlert();
    }

    public void showSuccessfulPersonalDetailsCreationAlert()
    {

        Alert successfulPersonalDetails = new Alert(Alert.AlertType.ERROR);
        successfulPersonalDetails.setHeaderText("Personal Details created successfully for " + createPersonalDetailsView.getHomeView().getUser().getUsername());
        successfulPersonalDetails.show();
    }
}
