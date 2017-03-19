package project.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import project.Database.Personal_Detail.PersonalDetail;
import project.Database.Personal_Detail.PersonalDetailController;
import project.Views.ReadAmendPersonalDetailsView;

/**
 * Created by Osama Khaliq
 * Version (03/03/2016)
 * ReadAmendPersonalDetailsView Window controller Class
 * Responsible for ReadAmendPersonalDetailsView window event handling
 * Changes to edit mode or read mode for a PersonalDetail object.
 */
public class ReadAmendPersonalDetailsController {

    private PersonalDetailController personalDetailController;

    @FXML
    private Button buttonView;

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
    public ReadAmendPersonalDetailsController(ReadAmendPersonalDetailsView readAmendPersonalDetailsView, PersonalDetailController personalDetailController)
    {
        this.readAmendPersonalDetailsView = readAmendPersonalDetailsView;
        this.personalDetailController = personalDetailController;

    }

    /**
     * Checks what mode the view has started in and adjusts the properites for thhe controls
     */
    public void checkMode()
    {
        if(!readAmendPersonalDetailsView.isAmendMode())
        {
            readAmendPersonalDetailsView.getStage().setTitle("Read Personal Details");
            buttonAmend.setDisable(true);

            txtFieldSurname.setEditable(false);

            txtFieldName.setEditable(false);

            txtFieldDateOfBirth.setEditable(false);

            txtFieldAddress.setEditable(false);

            txtFieldTownCity.setEditable(false);

            txtFieldCounty.setEditable(false);

            txtFieldPostcode.setEditable(false);

            txtFieldTelephoneNumber.setEditable(false);

            txtFieldMobileNumber.setEditable(false);

            txtFieldEmergencyContact.setEditable(false);

            txtFieldEmergencyContactNumber.setEditable(false);

        }else
        {
            readAmendPersonalDetailsView.getStage().setTitle("Amend Personal Details");
            buttonAmend.setDisable(false);

            txtFieldSurname.setEditable(true);

            txtFieldName.setEditable(true);

            txtFieldDateOfBirth.setEditable(true);

            txtFieldAddress.setEditable(true);

            txtFieldTownCity.setEditable(true);

            txtFieldCounty.setEditable(true);

            txtFieldPostcode.setEditable(true);

            txtFieldTelephoneNumber.setEditable(true);

            txtFieldMobileNumber.setEditable(true);

            txtFieldEmergencyContact.setEditable(true);

            txtFieldEmergencyContactNumber.setEditable(true);

        }
    }
    /**
     * Method sets the text of the fields in window with values from a PersonalDetail object
     * @param userName user to load PersonalDetail object from
     */
    public void loadPersonalDetails(String userName) {

        if (readAmendPersonalDetailsView.getHomeView().getHrDatabaseController().getPersonalDetail(userName) != null)
        {
            if (!readAmendPersonalDetailsView.isAmendMode()) {
                PersonalDetail personalDetail = readAmendPersonalDetailsView.getHomeView().getHrDatabaseController().getPersonalDetail(txtFieldUserName.getText());

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

            } else {

                PersonalDetail personalDetail = readAmendPersonalDetailsView.getHomeView().getHrDatabaseController().getPersonalDetail(userName);

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
        }else
        {
            showNoPersonalDetailFoundAlert(userName);
        }
    }


    /**
     * Creates a new PersonalDetail and sets the existing PersonalDetail to the new one in the database.
     * @param userName
     */
    public void amendPersonalDetail(String userName)
    {
        if (readAmendPersonalDetailsView.getHomeView().getHrDatabaseController().getPersonalDetail(userName) != null)
        {
            PersonalDetail newPersonalDetail = new PersonalDetail();

            newPersonalDetail.setUserName(userName);
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

            showSuccessfulPersonalDetailsAmendAlert(userName);
            readAmendPersonalDetailsView.closeReadPersonalDetailsView();
        }else
        {
            showNoPersonalDetailFoundAlert(userName);
        }

    }

    @FXML

    public void onButtonViewClick()
    {
        loadPersonalDetails(txtFieldUserName.getText());
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
        amendPersonalDetail(txtFieldUserName.getText());
    }

    /**
     * Shows Alert box for successful PersonalDetail amendment
     */
    public void showSuccessfulPersonalDetailsAmendAlert(String userName)
    {

        Alert successfulPersonalDetails = new Alert(Alert.AlertType.INFORMATION);
        successfulPersonalDetails.setHeaderText("Personal Detail amened successfully for " + userName);
        successfulPersonalDetails.show();
    }

    public void showNoPersonalDetailFoundAlert(String userName)
    {

        Alert noPersonalDetailFound = new Alert(Alert.AlertType.ERROR);
        noPersonalDetailFound.setHeaderText("No Personal Detail found for " +  userName);
        noPersonalDetailFound.show();
    }

    public Button getButtonView() {
        return buttonView;
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
