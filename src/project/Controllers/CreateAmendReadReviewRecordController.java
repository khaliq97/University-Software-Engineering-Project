package project.Controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import project.Database.Review.AnnualReviewRecord;
import project.Views.CreateAmendReadReviewRecordView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aman Gohel
 * CreateAmendReadReviewRecordView controller class.
 * Class implements creating, amending and reading a AnnualReviewRecord object.
 * Modes are switched with booleans, isCreateMode, isAmendMode and isReadMode.
 * Which mode is determined by methods in CreateAmendReadReviewRecordView.
 * Implements Alert Boxes.
 *
 * @Author Aman Gohel
 * @version (25/03/2017
 */
public class CreateAmendReadReviewRecordController {

    private CreateAmendReadReviewRecordView createAmendViewReviewRecordView;

    private boolean isCreateMode;
    private boolean isAmendMode;
    private boolean isReadMode;

    @FXML
    private Button buttonLoad;

    @FXML
    private TextField txtFieldYear;

    @FXML
    private TextField txtFieldStaffNumber;

    @FXML
    private TextField txtFieldName;

    @FXML
    private TextField txtFieldSection;

    @FXML
    private TextField txtFieldManagerDirectorName;

    @FXML
    private TextField txtFieldSecondManagerDirectorName;

    @FXML
    private TextArea txtFieldObjectives;

    @FXML
    private TextArea txtFieldAchievement;

    @FXML
    private  TextArea txtFieldPreview;

    @FXML
    private TextArea txtFieldReviewComments;

    @FXML
    private ComboBox comboBoxRecommendation;

    @FXML
    private TextField txtFieldRevieweeSignature;

    @FXML
    private TextField txtFieldManagerDirectorSignature;

    @FXML
    private TextField txtFieldSecondReviewerSignature;

    @FXML
    private TextField txtFieldDateSigned;

    @FXML
    private CheckBox checkBoxSigned;

    @FXML
    private Button completeRecordButton;

    private boolean signedOff;

    /**
     * Constructor for Class
     * @param createAmendReadReviewRecordView createAmendReadReviewRecordView class
     */
    public CreateAmendReadReviewRecordController(CreateAmendReadReviewRecordView createAmendReadReviewRecordView) {
        this.createAmendViewReviewRecordView = createAmendReadReviewRecordView;
    }


    /**
     * Checks what boolean out of isCreateMode, isAmendMode and isReadMode.
     * Sets up the window depending on which boolean is set to true
     * TextField editable properties, window title and button text are changed
     */
    public void checkMode()
    {
        signedOff = false;
        if(isCreateMode)
        {
            clearFields();
            completeRecordButton.setText("Complete Record");
            completeRecordButton.setDisable(false);

            buttonLoad.setVisible(false);

            txtFieldYear.setEditable(true);
            txtFieldStaffNumber.setEditable(true);
            txtFieldName.setEditable(true);
            txtFieldSection.setEditable(true);
            txtFieldManagerDirectorName.setEditable(true);
            txtFieldSecondManagerDirectorName.setEditable(true);
            txtFieldObjectives.setEditable(true);
            txtFieldAchievement.setEditable(true);
            txtFieldPreview.setEditable(true);
            txtFieldReviewComments.setEditable(true);
            comboBoxRecommendation.setEditable(true);
            txtFieldRevieweeSignature.setEditable(true);
            txtFieldManagerDirectorSignature.setEditable(true);
            txtFieldSecondReviewerSignature.setEditable(true);
            txtFieldDateSigned.setEditable(true);
            checkBoxSigned.setDisable(false);
        }

        if(isReadMode)
        {
            clearFields();
            completeRecordButton.setDisable(true);
            buttonLoad.setVisible(true);

            txtFieldYear.setEditable(true);
            txtFieldStaffNumber.setEditable(true);
            txtFieldName.setEditable(false);
            txtFieldSection.setEditable(false);
            txtFieldManagerDirectorName.setEditable(false);
            txtFieldSecondManagerDirectorName.setEditable(false);
            txtFieldObjectives.setEditable(false);
            txtFieldAchievement.setEditable(false);
            txtFieldPreview.setEditable(false);
            txtFieldReviewComments.setEditable(false);
            comboBoxRecommendation.setEditable(false);
            txtFieldRevieweeSignature.setEditable(false);
            txtFieldManagerDirectorSignature.setEditable(false);
            txtFieldSecondReviewerSignature.setEditable(false);
            txtFieldDateSigned.setEditable(false);
            checkBoxSigned.setDisable(true);

        }

        if(isAmendMode)
        {
            clearFields();
            completeRecordButton.setText("Amend Record");
            completeRecordButton.setDisable(true);

            buttonLoad.setVisible(true);

            txtFieldYear.setEditable(true);
            txtFieldStaffNumber.setEditable(true);
            txtFieldName.setEditable(true);
            txtFieldSection.setEditable(true);
            txtFieldManagerDirectorName.setEditable(true);
            txtFieldSecondManagerDirectorName.setEditable(true);
            txtFieldObjectives.setEditable(true);
            txtFieldAchievement.setEditable(true);
            txtFieldPreview.setEditable(true);
            txtFieldReviewComments.setEditable(true);
            comboBoxRecommendation.setEditable(true);
            txtFieldRevieweeSignature.setEditable(true);
            txtFieldManagerDirectorSignature.setEditable(true);
            txtFieldSecondReviewerSignature.setEditable(true);
            txtFieldDateSigned.setEditable(true);
            checkBoxSigned.setDisable(false);
        }
    }

    /**
     * Clears the text in all textfield controls.
     */
    public void clearFields()
    {
        txtFieldYear.clear();
        txtFieldStaffNumber.clear();
        txtFieldName.clear();
        txtFieldSection.clear();
        txtFieldManagerDirectorName.clear();
        txtFieldSecondManagerDirectorName.clear();
        txtFieldObjectives.clear();
        txtFieldAchievement.clear();
        txtFieldPreview.clear();
        txtFieldReviewComments.clear();
        comboBoxRecommendation.getSelectionModel().clearSelection();
        txtFieldRevieweeSignature.clear();
        txtFieldManagerDirectorSignature.clear();
        txtFieldSecondReviewerSignature.clear();
        txtFieldDateSigned.clear();
        checkBoxSigned.setSelected(false);
    }

    /**
     * buttonLoad onMouseClick event handler
     */
    @FXML
    public void onButtonLoadClick()
    {
        readReviewRecord();
    }

    /**
     * Populates the textfield's with data from a AnnualReviewRecord object
     * Will not populate textfield's if the review's isSigned is true and isAmendMode is true
     * isReadMode populates normally
     */
    public void readReviewRecord()
    {
        AnnualReviewRecord annualReviewRecordRecordToRead = createAmendViewReviewRecordView.getReviewController().getReviewRecord(txtFieldStaffNumber.getText(), txtFieldYear.getText());
        if(annualReviewRecordRecordToRead != null)
        {
            if(isAmendMode)
            {
                if(!annualReviewRecordRecordToRead.isSigned())
                {
                    completeRecordButton.setDisable(false);
                    txtFieldStaffNumber.setText(annualReviewRecordRecordToRead.getStaffNumber());
                    txtFieldName.setText(annualReviewRecordRecordToRead.getName());
                    txtFieldSection.setText(annualReviewRecordRecordToRead.getSection());
                    txtFieldManagerDirectorName.setText(annualReviewRecordRecordToRead.getManagerDirectorName());
                    txtFieldSecondManagerDirectorName.setText(annualReviewRecordRecordToRead.getSecondManagerDirectorName());
                    txtFieldObjectives.setText(annualReviewRecordRecordToRead.getObjectives());
                    txtFieldAchievement.setText(annualReviewRecordRecordToRead.getAchievement());
                    txtFieldPreview.setText(annualReviewRecordRecordToRead.getPreview());
                    txtFieldReviewComments.setText(annualReviewRecordRecordToRead.getReviewComments());
                    if(annualReviewRecordRecordToRead.getRecommendation().equals("Promotion"))
                    {
                        comboBoxRecommendation.getSelectionModel().select(0);
                    }else if(annualReviewRecordRecordToRead.getRecommendation().equals("No Promotion"))
                    {
                        comboBoxRecommendation.getSelectionModel().select(1);
                    }

                    txtFieldRevieweeSignature.setText(annualReviewRecordRecordToRead.getRevieweeSignature());
                    txtFieldManagerDirectorSignature.setText(annualReviewRecordRecordToRead.getManagerDirectorSignature());
                    txtFieldSecondReviewerSignature.setText(annualReviewRecordRecordToRead.getSecondReviewerSignature());
                    txtFieldDateSigned.setText(annualReviewRecordRecordToRead.getDateSigned());
                    checkBoxSigned.setSelected(annualReviewRecordRecordToRead.isSigned());
                }else
                {
                    clearFields();
                    showCannotAmendSignedReviewRecord(annualReviewRecordRecordToRead.getStaffNumber(), annualReviewRecordRecordToRead.getYear());
                }
            }else if(isReadMode)
            {
                completeRecordButton.setDisable(true);
                txtFieldStaffNumber.setText(annualReviewRecordRecordToRead.getStaffNumber());
                txtFieldName.setText(annualReviewRecordRecordToRead.getName());
                txtFieldSection.setText(annualReviewRecordRecordToRead.getSection());
                txtFieldManagerDirectorName.setText(annualReviewRecordRecordToRead.getManagerDirectorName());
                txtFieldSecondManagerDirectorName.setText(annualReviewRecordRecordToRead.getSecondManagerDirectorName());
                txtFieldObjectives.setText(annualReviewRecordRecordToRead.getObjectives());
                txtFieldAchievement.setText(annualReviewRecordRecordToRead.getAchievement());
                txtFieldPreview.setText(annualReviewRecordRecordToRead.getPreview());
                txtFieldReviewComments.setText(annualReviewRecordRecordToRead.getReviewComments());
                if(annualReviewRecordRecordToRead.getRecommendation().equals("Promotion"))
                {
                    comboBoxRecommendation.getSelectionModel().select(0);
                }else if(annualReviewRecordRecordToRead.getRecommendation().equals("No Promotion"))
                {
                    comboBoxRecommendation.getSelectionModel().select(1);
                }

                txtFieldRevieweeSignature.setText(annualReviewRecordRecordToRead.getRevieweeSignature());
                txtFieldManagerDirectorSignature.setText(annualReviewRecordRecordToRead.getManagerDirectorSignature());
                txtFieldSecondReviewerSignature.setText(annualReviewRecordRecordToRead.getSecondReviewerSignature());
                txtFieldDateSigned.setText(annualReviewRecordRecordToRead.getDateSigned());
                checkBoxSigned.setSelected(annualReviewRecordRecordToRead.isSigned());
            }



        }else
        {

            completeRecordButton.setDisable(true);

            showRecordDoesNotExistAlert(txtFieldStaffNumber.getText(), txtFieldYear.getText());
        }
    }

    /**
     * buttonCompleteRecord onMouseClick event handler
     */
    @FXML
    public void onCompleteRecordButtonClick()
    {
        if(isCreateMode)
        {
            createReviewRecord();
        }

        if(isAmendMode)
        {
            amendReviewRecord();
        }

        clearFields();
    }

    /**
     * Calls createReviewRecord method in ReviewController
     * Shows the appropriate alert box based on the return value from createReviewRecord in ReviewController
     */
    public void createReviewRecord()
    {
        int result = createAmendViewReviewRecordView.getReviewController().createReviewRecord(txtFieldYear.getText(), txtFieldStaffNumber.getText(), txtFieldName.getText(), txtFieldSection.getText(), txtFieldManagerDirectorName.getText(),
                txtFieldSecondManagerDirectorName.getText(), txtFieldObjectives.getText(), txtFieldAchievement.getText(), txtFieldPreview.getText(),
                txtFieldReviewComments.getText(), comboBoxRecommendation.getSelectionModel().getSelectedItem().toString(), txtFieldRevieweeSignature.getText(), txtFieldManagerDirectorSignature.getText(), txtFieldSecondReviewerSignature.getText(), txtFieldDateSigned.getText(), signedOff);

        if(result == 1)
        {
            showSuccessfulReviewRecordCreationAlert(txtFieldStaffNumber.getText(), txtFieldYear.getText());
            createAmendViewReviewRecordView.closeCreateAmendReadReviewRecordView();
        }else if(result == 0)
        {
            showReviewRecordAlreadyExists(txtFieldStaffNumber.getText(), txtFieldYear.getText());
        }
    }

    /**
     * Calls amendReviewRecord in ReviewController
     * Gets a review record based on the values in txtFieldStaffNumber and txtFieldYear.
     * Then amends the review object with the data in the textfield's.
     */
    public void amendReviewRecord()
    {
        if(createAmendViewReviewRecordView.getReviewController().getReviewRecord(txtFieldStaffNumber.getText(), txtFieldYear.getText()) != null)
        {
            AnnualReviewRecord annualReviewRecordToSet = new AnnualReviewRecord(txtFieldYear.getText(), txtFieldStaffNumber.getText(), txtFieldName.getText(), txtFieldSection.getText(), txtFieldManagerDirectorName.getText(),
                    txtFieldSecondManagerDirectorName.getText(), txtFieldObjectives.getText(), txtFieldAchievement.getText(), txtFieldPreview.getText(),
                    txtFieldReviewComments.getText(), comboBoxRecommendation.getSelectionModel().getSelectedItem().toString(),
                    txtFieldRevieweeSignature.getText(), txtFieldManagerDirectorSignature.getText(), txtFieldSecondReviewerSignature.getText(), txtFieldDateSigned.getText(), signedOff);


            createAmendViewReviewRecordView.getReviewController().amendReviewRecord(annualReviewRecordToSet);
            showSuccessfulReviewRecordAmendedAlert(txtFieldStaffNumber.getText(), txtFieldYear.getText());
            createAmendViewReviewRecordView.closeCreateAmendReadReviewRecordView();

        }else
        {
            showRecordDoesNotExistAlert(txtFieldStaffNumber.getText(), txtFieldStaffNumber.getText());
        }
    }

    /**
     * checkBoxSigned onMouseClick event handler
     */
    @FXML
    public void onCheckBoxSignedClick()
    {
        if(checkBoxSigned.isSelected())
        {
            signOffReview();
        }else
        {
            signedOff = false;
        }

    }

    /**
     * Sets signedOff to true
     */
    public void signOffReview()
    {
        signedOff = true;
    }

    /**
     * Sets all modes to false except isCreateMode
     */
    public void createMode()
    {
        isCreateMode = true;
        isReadMode = false;
        isAmendMode = false;

        checkMode();

    }

    /**
     * Sets all modes to false except isReadMode
     */
    public void readMode()
    {
        isReadMode = true;
        isCreateMode = false;
        isAmendMode = false;

        checkMode();
    }

    /**
     * Sets all modes to false except isAmendMode
     */
    public void amendMode()
    {
        isReadMode = false;
        isCreateMode = false;
        isAmendMode = true;

        checkMode();
    }

    /**
     * Adds items to the comboBoxRecommendation control
     */
    public void populateComboBoxRecommendation()
    {
        List<String> recommendationItems = new ArrayList<String>();
        recommendationItems.add("Promotion");
        recommendationItems.add("No Promotion");

        ObservableList observableList = FXCollections.observableList(recommendationItems);
        comboBoxRecommendation.setItems(observableList);
    }

    /**
     * Shows AlertBox when a AnnualReviewRecord object is successfully created and added to reviews ArrayList in HRDatabse
     * @param username username of review object created
     * @param year year of review object created
     */
    public void showSuccessfulReviewRecordCreationAlert(String username, String year)
    {
        Alert successfulReviewRecordCreationAlert = new Alert(Alert.AlertType.INFORMATION);
        successfulReviewRecordCreationAlert.setHeaderText("AnnualReviewRecord record successfully created for " + username + " at year " + year);
        successfulReviewRecordCreationAlert.show();
    }

    /**
     * Shows AlertBox when a AnnualReviewRecord object cannot be amended as it's isSigned boolean is true
     * @param username username of review object to be amended
     * @param year year of review object to be amended
     */
    public void showCannotAmendSignedReviewRecord(String username, String year)
    {
        Alert cannotAmendSignedReviewRecord = new Alert(Alert.AlertType.ERROR);
        cannotAmendSignedReviewRecord.setHeaderText("AnnualReviewRecord record cannot be amended for" + username + " at year " + year +  " as it's already signed off");
        cannotAmendSignedReviewRecord.show();
    }

    /**
     * Shows AlertBox when a AnnualReviewRecord object has been amended successfully
     * @param username username of review object to be amended
     * @param year year of review object to be amended
     */
    public void showSuccessfulReviewRecordAmendedAlert(String username, String year)
    {
        Alert SuccessfulReviewRecordAmendedAlert = new Alert(Alert.AlertType.INFORMATION);
        SuccessfulReviewRecordAmendedAlert.setHeaderText("AnnualReviewRecord record successfully amended for " + username + " at year " + year);
        SuccessfulReviewRecordAmendedAlert.show();
    }

    /**
     * Shows AlertBox when a AnnualReviewRecord object already exists in the reviews ArrayList in HRDatabase
     * @param username username of review object to be created
     * @param year year of review object to be created
     */
    public void showReviewRecordAlreadyExists(String username, String year)
    {
        Alert reviewRecordAlreadyExists = new Alert(Alert.AlertType.ERROR);
        reviewRecordAlreadyExists.setHeaderText("AnnualReviewRecord record already exists for " + username + " at year " + year);
        reviewRecordAlreadyExists.show();
    }

    /**
     * Shows AlertBox when a AnnualReviewRecord object does not exist
     * @param username username of review object trying to be found
     * @param year year of review object trying to be found
     */
    public void showRecordDoesNotExistAlert(String username, String year)
    {
        Alert recordDoesNotExistAlert = new Alert(Alert.AlertType.ERROR);
        recordDoesNotExistAlert.setHeaderText("AnnualReviewRecord record does not exist for " + username + " at year " + year);
        recordDoesNotExistAlert.show();
    }

}



