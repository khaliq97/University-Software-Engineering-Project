package project.Controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import project.Database.Review.Review;
import project.Views.CreateAmendReadReviewRecordView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 18/03/17.
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


    public CreateAmendReadReviewRecordController(CreateAmendReadReviewRecordView createAmendReadReviewRecordView) {
        this.createAmendViewReviewRecordView = createAmendReadReviewRecordView;
    }


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

    @FXML
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

    @FXML
    public void onButtonLoadClick()
    {
        readReviewRecord();
    }

    public void readReviewRecord()
    {
        Review reviewRecordToRead = createAmendViewReviewRecordView.getReviewController().getReviewRecord(txtFieldStaffNumber.getText(), txtFieldYear.getText());
        if(reviewRecordToRead != null)
        {
            if(isAmendMode)
            {
                if(!reviewRecordToRead.isSigned())
                {
                    completeRecordButton.setDisable(false);
                    txtFieldStaffNumber.setText(reviewRecordToRead.getStaffNumber());
                    txtFieldName.setText(reviewRecordToRead.getName());
                    txtFieldSection.setText(reviewRecordToRead.getSection());
                    txtFieldManagerDirectorName.setText(reviewRecordToRead.getManagerDirectorName());
                    txtFieldSecondManagerDirectorName.setText(reviewRecordToRead.getSecondManagerDirectorName());
                    txtFieldObjectives.setText(reviewRecordToRead.getObjectives());
                    txtFieldAchievement.setText(reviewRecordToRead.getAchievement());
                    txtFieldPreview.setText(reviewRecordToRead.getPreview());
                    txtFieldReviewComments.setText(reviewRecordToRead.getReviewComments());
                    if(reviewRecordToRead.getRecommendation().equals("Promotion"))
                    {
                        comboBoxRecommendation.getSelectionModel().select(0);
                    }else if(reviewRecordToRead.getRecommendation().equals("No Promotion"))
                    {
                        comboBoxRecommendation.getSelectionModel().select(1);
                    }

                    txtFieldRevieweeSignature.setText(reviewRecordToRead.getRevieweeSignature());
                    txtFieldManagerDirectorSignature.setText(reviewRecordToRead.getManagerDirectorSignature());
                    txtFieldSecondReviewerSignature.setText(reviewRecordToRead.getSecondReviewerSignature());
                    txtFieldDateSigned.setText(reviewRecordToRead.getDateSigned());
                    checkBoxSigned.setSelected(reviewRecordToRead.isSigned());
                }else
                {
                    clearFields();
                    showCannotAmendSignedReviewRecord(reviewRecordToRead.getStaffNumber(), reviewRecordToRead.getYear());
                }
            }else if(isReadMode)
            {
                completeRecordButton.setDisable(true);
                txtFieldStaffNumber.setText(reviewRecordToRead.getStaffNumber());
                txtFieldName.setText(reviewRecordToRead.getName());
                txtFieldSection.setText(reviewRecordToRead.getSection());
                txtFieldManagerDirectorName.setText(reviewRecordToRead.getManagerDirectorName());
                txtFieldSecondManagerDirectorName.setText(reviewRecordToRead.getSecondManagerDirectorName());
                txtFieldObjectives.setText(reviewRecordToRead.getObjectives());
                txtFieldAchievement.setText(reviewRecordToRead.getAchievement());
                txtFieldPreview.setText(reviewRecordToRead.getPreview());
                txtFieldReviewComments.setText(reviewRecordToRead.getReviewComments());
                if(reviewRecordToRead.getRecommendation().equals("Promotion"))
                {
                    comboBoxRecommendation.getSelectionModel().select(0);
                }else if(reviewRecordToRead.getRecommendation().equals("No Promotion"))
                {
                    comboBoxRecommendation.getSelectionModel().select(1);
                }

                txtFieldRevieweeSignature.setText(reviewRecordToRead.getRevieweeSignature());
                txtFieldManagerDirectorSignature.setText(reviewRecordToRead.getManagerDirectorSignature());
                txtFieldSecondReviewerSignature.setText(reviewRecordToRead.getSecondReviewerSignature());
                txtFieldDateSigned.setText(reviewRecordToRead.getDateSigned());
                checkBoxSigned.setSelected(reviewRecordToRead.isSigned());
            }



        }else
        {

            completeRecordButton.setDisable(true);

            showRecordDoesNotExistAlert(txtFieldStaffNumber.getText(), txtFieldYear.getText());
        }
    }

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

    public void amendReviewRecord()
    {
        if(createAmendViewReviewRecordView.getReviewController().getReviewRecord(txtFieldStaffNumber.getText(), txtFieldYear.getText()) != null)
        {
            Review reviewToSet = new Review(txtFieldYear.getText(), txtFieldStaffNumber.getText(), txtFieldName.getText(), txtFieldSection.getText(), txtFieldManagerDirectorName.getText(),
                    txtFieldSecondManagerDirectorName.getText(), txtFieldObjectives.getText(), txtFieldAchievement.getText(), txtFieldPreview.getText(),
                    txtFieldReviewComments.getText(), comboBoxRecommendation.getSelectionModel().getSelectedItem().toString(),
                    txtFieldRevieweeSignature.getText(), txtFieldManagerDirectorSignature.getText(), txtFieldSecondReviewerSignature.getText(), txtFieldDateSigned.getText(), signedOff);


            createAmendViewReviewRecordView.getReviewController().amendReviewRecord(reviewToSet);
            showSuccessfulReviewRecordAmendedAlert(txtFieldStaffNumber.getText(), txtFieldYear.getText());
            createAmendViewReviewRecordView.closeCreateAmendReadReviewRecordView();

        }else
        {
            showRecordDoesNotExistAlert(txtFieldStaffNumber.getText(), txtFieldStaffNumber.getText());
        }
    }

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
    public void signOffReview()
    {
        signedOff = true;
    }

    public void createMode()
    {
        isCreateMode = true;
        isReadMode = false;
        isAmendMode = false;

        checkMode();

    }

    public void readMode()
    {
        isReadMode = true;
        isCreateMode = false;
        isAmendMode = false;

        checkMode();
    }

    public void amendMode()
    {
        isReadMode = false;
        isCreateMode = false;
        isAmendMode = true;

        checkMode();
    }

    public void populateComboBoxRecommendation()
    {
        List<String> recommendationItems = new ArrayList<String>();
        recommendationItems.add("Promotion");
        recommendationItems.add("No Promotion");

        ObservableList observableList = FXCollections.observableList(recommendationItems);
        comboBoxRecommendation.setItems(observableList);
    }

    public void showSuccessfulReviewRecordCreationAlert(String username, String year)
    {
        Alert successfulReviewRecordCreationAlert = new Alert(Alert.AlertType.INFORMATION);
        successfulReviewRecordCreationAlert.setHeaderText("Review record successfully created for " + username + " at year " + year);
        successfulReviewRecordCreationAlert.show();
    }

    public void showCannotAmendSignedReviewRecord(String username, String year)
    {
        Alert cannotAmendSignedReviewRecord = new Alert(Alert.AlertType.ERROR);
        cannotAmendSignedReviewRecord.setHeaderText("Review record cannot be amended for" + username + " at year " + year +  " as it's already signed off");
        cannotAmendSignedReviewRecord.show();
    }

    public void showSuccessfulReviewRecordAmendedAlert(String username, String year)
    {
        Alert SuccessfulReviewRecordAmendedAlert = new Alert(Alert.AlertType.INFORMATION);
        SuccessfulReviewRecordAmendedAlert.setHeaderText("Review record successfully amended for " + username + " at year " + year);
        SuccessfulReviewRecordAmendedAlert.show();
    }

    public void showReviewRecordAlreadyExists(String username, String year)
    {
        Alert reviewRecordAlreadyExists = new Alert(Alert.AlertType.ERROR);
        reviewRecordAlreadyExists.setHeaderText("Review record already exists for " + username + " at year " + year);
        reviewRecordAlreadyExists.show();
    }

    public void showRecordDoesNotExistAlert(String username, String year)
    {
        Alert recordDoesNotExistAlert = new Alert(Alert.AlertType.ERROR);
        recordDoesNotExistAlert.setHeaderText("Review record does not exist for " + username + " at year " + year);
        recordDoesNotExistAlert.show();
    }

}



