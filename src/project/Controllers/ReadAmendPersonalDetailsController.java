package project.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import project.Database.User.PersonalDetail;
import project.Views.ReadAmendPersonalDetailsView;

/**
 * Created by osamakhaliq on 02/03/17.
 */
public class ReadAmendPersonalDetailsController {


    @FXML
    private Button buttonAmend;

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

    ReadAmendPersonalDetailsView readAmendPersonalDetailsView;

    public ReadAmendPersonalDetailsController(ReadAmendPersonalDetailsView readAmendPersonalDetailsView)
    {
        this.readAmendPersonalDetailsView = readAmendPersonalDetailsView;
    }

    public void loadPersonalDetails(String userName)
    {
        if(!readAmendPersonalDetailsView.isAmendMode())
        {
            readAmendPersonalDetailsView.getStage().setTitle("Read Personal Details");
            buttonAmend.setDisable(true);
            PersonalDetail personalDetail = readAmendPersonalDetailsView.getHomeView().getHrDatabaseController().getPersonalDetails(userName);

            txtFieldSurname.setText(personalDetail.getSurname());
            txtFieldSurname.setEditable(false);

            txtFieldName.setText(personalDetail.getName());
            txtFieldName.setEditable(false);

            txtFieldDateOfBirth.setText(personalDetail.getDOB());
            txtFieldDateOfBirth.setEditable(false);

            txtFieldAddress.setText(personalDetail.getAddress());
            txtFieldAddress.setEditable(false);

            txtFieldTownCity.setText(personalDetail.getTownCity());
            txtFieldTownCity.setEditable(false);

            txtFieldCounty.setText(personalDetail.getCounty());
            txtFieldCounty.setEditable(false);

            txtFieldPostcode.setText(personalDetail.getPostcode());
            txtFieldPostcode.setEditable(false);

            txtFieldTelephoneNumber.setText(String.valueOf(personalDetail.getTelephoneNumber()));
            txtFieldTelephoneNumber.setEditable(false);

            txtFieldMobileNumber.setText(String.valueOf(personalDetail.getMobileNumber()));
            txtFieldMobileNumber.setEditable(false);

            txtFieldEmergencyContact.setText(personalDetail.getEmergencyContact());
            txtFieldEmergencyContact.setEditable(false);

            txtFieldEmergencyContactNumber.setText(String.valueOf(personalDetail.getEmergencyContactNumber()));
            txtFieldEmergencyContactNumber.setEditable(false);

        }else
        {
            readAmendPersonalDetailsView.getStage().setTitle("Amend Personal Details");
            buttonAmend.setDisable(false);

            PersonalDetail personalDetail = readAmendPersonalDetailsView.getHomeView().getHrDatabaseController().getPersonalDetails(userName);

            txtFieldSurname.setText(personalDetail.getSurname());
            txtFieldSurname.setEditable(true);

            txtFieldName.setText(personalDetail.getName());
            txtFieldName.setEditable(true);

            txtFieldDateOfBirth.setText(personalDetail.getDOB());
            txtFieldDateOfBirth.setEditable(true);

            txtFieldAddress.setText(personalDetail.getAddress());
            txtFieldAddress.setEditable(true);

            txtFieldTownCity.setText(personalDetail.getTownCity());
            txtFieldTownCity.setEditable(true);

            txtFieldCounty.setText(personalDetail.getCounty());
            txtFieldCounty.setEditable(true);

            txtFieldPostcode.setText(personalDetail.getPostcode());
            txtFieldPostcode.setEditable(true);

            txtFieldTelephoneNumber.setText(String.valueOf(personalDetail.getTelephoneNumber()));
            txtFieldTelephoneNumber.setEditable(true);

            txtFieldMobileNumber.setText(String.valueOf(personalDetail.getMobileNumber()));
            txtFieldMobileNumber.setEditable(true);

            txtFieldEmergencyContact.setText(personalDetail.getEmergencyContact());
            txtFieldEmergencyContact.setEditable(true);

            txtFieldEmergencyContactNumber.setText(String.valueOf(personalDetail.getEmergencyContactNumber()));
            txtFieldEmergencyContactNumber.setEditable(true);

        }


    }

    @FXML
    public void onButtonLoadClick()
    {

    }

    @FXML
    public void onButtonAmendClick()
    {
        PersonalDetail newPersonalDetail = new PersonalDetail();

        newPersonalDetail.setUserName(readAmendPersonalDetailsView.getHomeView().getUserSession().getUser().getUsername());
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

        int index = 0;
        for(PersonalDetail personalDetail: readAmendPersonalDetailsView.getHomeView().getHrDatabaseController().getHrDatabase().getPersonalDetails())
        {
            if(personalDetail.getUserName().equals(newPersonalDetail.getUserName()))
            {
                readAmendPersonalDetailsView.getHomeView().getHrDatabaseController().getHrDatabase().getPersonalDetails().set(index, newPersonalDetail);
            }
            index++;
        }

        readAmendPersonalDetailsView.getHomeView().getHrDatabaseController().writeToDatabase();
        readAmendPersonalDetailsView.getHomeView().getHrDatabaseController().populateHRDatabase();

        showSuccessfulPersonalDetailsAmendAlert();
        readAmendPersonalDetailsView.closeReadPersonalDetailsView();
    }

    public void showSuccessfulPersonalDetailsAmendAlert()
    {

        Alert successfulPersonalDetails = new Alert(Alert.AlertType.INFORMATION);
        successfulPersonalDetails.setHeaderText("Personal Details amened successfully for " + readAmendPersonalDetailsView.getHomeView().getUserSession().getUser().getUsername());
        successfulPersonalDetails.show();
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

    public ReadAmendPersonalDetailsView getReadAmendPersonalDetailsView() {
        return readAmendPersonalDetailsView;
    }
}
