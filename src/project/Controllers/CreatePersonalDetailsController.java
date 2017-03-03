package project.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import project.Database.User.PersonalDetail;
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

        newPersonalDetail.setUserName(createPersonalDetailsView.getHomeView().getUserSession().getUser().getUsername());
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
    }

    public void showSuccessfulPersonalDetailsCreationAlert()
    {

        Alert successfulPersonalDetails = new Alert(Alert.AlertType.INFORMATION);
        successfulPersonalDetails.setHeaderText("Personal Details created successfully for " + createPersonalDetailsView.getHomeView().getUserSession().getUser().getUsername());
        successfulPersonalDetails.show();
    }
}
