package project.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import project.PersonalDetail;
import project.Views.ReadPersonalDetailsView;

/**
 * Created by osamakhaliq on 02/03/17.
 */
public class ReadPersonalDetailsController {



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

    ReadPersonalDetailsView readPersonalDetailsView;

    public ReadPersonalDetailsController(ReadPersonalDetailsView readPersonalDetailsView)
    {
        this.readPersonalDetailsView = readPersonalDetailsView;
    }

    public void loadPersonalDetails(String userName)
    {
        PersonalDetail personalDetail = readPersonalDetailsView.getHomeView().getHrDatabaseController().getPersonalDetails(userName);

        txtFieldSurname.setText(personalDetail.getSurname());
        txtFieldName.setText(personalDetail.getName());
        txtFieldDateOfBirth.setText(personalDetail.getDOB());
        txtFieldAddress.setText(personalDetail.getAddress());
        txtFieldTownCity.setText(personalDetail.getTownCity());
        txtFieldCounty.setText(personalDetail.getCounty());
        txtFieldPostcode.setText(personalDetail.getPostcode());
        txtFieldTelephoneNumber.setText(String.valueOf(personalDetail.getTelephoneNumber()));
        txtFieldMobileNumber.setText(String.valueOf(personalDetail.getMobileNumber()));
        txtFieldEmergencyContact.setText(personalDetail.getEmergencyContact());
        txtFieldEmergencyContactNumber.setText(String.valueOf(personalDetail.getEmergencyContactNumber()));

    }

    public TextField getTxtFieldUserName() {
        return txtFieldUserName;
    }

    public TextField getTxtFieldSurname() {
        return txtFieldSurname;
    }

    public TextField getTxtFieldName() {
        return txtFieldName;
    }

    public TextField getTxtFieldDateOfBirth() {
        return txtFieldDateOfBirth;
    }

    public TextField getTxtFieldAddress() {
        return txtFieldAddress;
    }

    public TextField getTxtFieldTownCity() {
        return txtFieldTownCity;
    }

    public TextField getTxtFieldCounty() {
        return txtFieldCounty;
    }

    public TextField getTxtFieldPostcode() {
        return txtFieldPostcode;
    }

    public TextField getTxtFieldTelephoneNumber() {
        return txtFieldTelephoneNumber;
    }

    public TextField getTxtFieldMobileNumber() {
        return txtFieldMobileNumber;
    }

    public TextField getTxtFieldEmergencyContact() {
        return txtFieldEmergencyContact;
    }

    public TextField getTxtFieldEmergencyContactNumber() {
        return txtFieldEmergencyContactNumber;
    }

    public ReadPersonalDetailsView getReadPersonalDetailsView() {
        return readPersonalDetailsView;
    }
}
