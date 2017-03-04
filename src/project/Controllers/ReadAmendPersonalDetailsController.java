package project.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import project.Database.User.PersonalDetail;
import project.Views.ReadAmendPersonalDetailsView;

/**
 * Created by Osama Khaliq
 * Version (03/03/2016)
 * ReadAmendPersonalDetailsView Window controller Class
 * Responsible for ReadAmendPersonalDetailsView window event handling
 * Changes to edit mode or read mode for a PersonalDetail object.
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

    /**
     * Constructor for class
     * @param readAmendPersonalDetailsView ReadAmendPersonalDetailsView Window
     */
    public ReadAmendPersonalDetailsController(ReadAmendPersonalDetailsView readAmendPersonalDetailsView)
    {
        this.readAmendPersonalDetailsView = readAmendPersonalDetailsView;
    }

    /**
     * Method sets the text of the fields in window with values from a PersonalDetail object
     * Sets the setEditable value depending if isAmendMode is true or false
     * @param userName user to load PersonalDetail object from
     */
    public void loadPersonalDetails(String userName)
    {
        if(readAmendPersonalDetailsView.getHomeView().getHrDatabaseController().getPersonalDetails(userName) != null)
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
        }else
        {
            readAmendPersonalDetailsView.closeReadPersonalDetailsView();
            showNoPersonalDetailFoundAlert();
        }



    }

    /**
     * Event handler for buttonAmend Button control
     * Creates new personal detail and sets values based on text field values
     * Finds and sets the existing PersonalDetail object to the new one
     * Writes it the HRDatabase and populates it.
     */
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

    /**
     * Shows Alert box for successful PersonalDetail amendment
     */
    public void showSuccessfulPersonalDetailsAmendAlert()
    {

        Alert successfulPersonalDetails = new Alert(Alert.AlertType.INFORMATION);
        successfulPersonalDetails.setHeaderText("Personal Detail amened successfully for " + readAmendPersonalDetailsView.getHomeView().getUserSession().getUser().getUsername());
        successfulPersonalDetails.show();
    }

    public void showNoPersonalDetailFoundAlert()
    {

        Alert noPersonalDetailFound = new Alert(Alert.AlertType.ERROR);
        noPersonalDetailFound.setHeaderText("No Personal Detail found for " + readAmendPersonalDetailsView.getHomeView().getUserSession().getUser().getUsername());
        noPersonalDetailFound.show();
    }

    /**
     * Returns readAmendPersonalDetailsView
     * @return readAmendPersonalDetailsView
     */
    public ReadAmendPersonalDetailsView getReadAmendPersonalDetailsView() {
        return readAmendPersonalDetailsView;
    }

    /**
     * Returns txtFieldUserName TextField control
     * @return txtFieldUserName
     */
    public TextField getTxtFieldUserName() {
        return txtFieldUserName;
    }

    /**
     * Returns txtFieldSurname TextField control
     * @return txtFieldSurname
     */
    public TextField getTxtFieldSurname() {
        return txtFieldSurname;
    }

    /**
     * Returns txtFieldName TextField control
     * @return txtFieldName
     */
    public TextField getTxtFieldName() {
        return txtFieldName;
    }

    /**
     * Returns txtFieldDateOfBirth TextField control
     * @return txtFieldDateOfBirth
     */
    public TextField getTxtFieldDateOfBirth() {
        return txtFieldDateOfBirth;
    }

    /**
     * Returns txtFieldAddress TextField control
     * @return txtFieldAddress
     */
    public TextField getTxtFieldAddress() {
        return txtFieldAddress;
    }

    /**
     * Returns txtFieldTownCity TextField control
     * @return txtFieldTownCity
     */
    public TextField getTxtFieldTownCity() {
        return txtFieldTownCity;
    }

    /**
     * Returns txtFieldCounty TextField control
     * @return txtFieldCounty
     */
    public TextField getTxtFieldCounty() {
        return txtFieldCounty;
    }

    /**
     * Returns txtFieldPostcode TextField control
     * @return txtFieldPostcode
     */
    public TextField getTxtFieldPostcode() {
        return txtFieldPostcode;
    }

    /**
     * Returns txtFieldTelephoneNumber TextField control
     * @return txtFieldTelephoneNumber
     */
    public TextField getTxtFieldTelephoneNumber() {
        return txtFieldTelephoneNumber;
    }

    /**
     * Returns txtFieldMobileNumber TextField control
     * @return txtFieldMobileNumber
     */
    public TextField getTxtFieldMobileNumber() {
        return txtFieldMobileNumber;
    }

    /**
     * Returns txtFieldEmergencyContact TextField control
     * @return txtFieldEmergencyContact
     */
    public TextField getTxtFieldEmergencyContact() {
        return txtFieldEmergencyContact;
    }

    /**
     * Returns txtFieldEmergencyContactNumber TextField control
     * @return txtFieldEmergencyContactNumber
     */
    public TextField getTxtFieldEmergencyContactNumber() {
        return txtFieldEmergencyContactNumber;
    }

}
