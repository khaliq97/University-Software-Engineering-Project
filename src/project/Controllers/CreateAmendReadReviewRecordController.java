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

    CreateAmendReadReviewRecordView createAmendViewReviewRecordView;

    boolean isCreateMode;
    boolean isAmendMode;
    boolean isReadMode;

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
    private Button completeRecordButton;



    public CreateAmendReadReviewRecordController(CreateAmendReadReviewRecordView createAmendReadReviewRecordView) {
        this.createAmendViewReviewRecordView = createAmendReadReviewRecordView;
    }


    public void checkMode()
    {
        if(isCreateMode)
        {
            completeRecordButton.setText("Complete Record");

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
        }

        if(isReadMode)
        {
            completeRecordButton.setText("Read Record");

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

        }
    }
    @FXML
    public void onCompleteRecordButtonClick()
    {
        if(isCreateMode)
        {
            int result = createAmendViewReviewRecordView.getReviewController().createReviewRecord(txtFieldYear.getText(), txtFieldStaffNumber.getText(), txtFieldName.getText(), txtFieldSection.getText(), txtFieldManagerDirectorName.getText(),
                    txtFieldSecondManagerDirectorName.getText(), txtFieldObjectives.getText(), txtFieldAchievement.getText(), txtFieldPreview.getText(),
                    txtFieldReviewComments.getText(), comboBoxRecommendation.getSelectionModel().getSelectedItem().toString());

            if(result == 1)
            {
                showSuccessfulReviewRecordCreationAlert(txtFieldStaffNumber.getText(), txtFieldYear.getText());
            }else if(result == 0)
            {
                showReviewRecordAlreadyExists(txtFieldStaffNumber.getText(), txtFieldYear.getText());
            }
        }

        if(isReadMode)
        {
            Review reviewRecordToRead = createAmendViewReviewRecordView.getReviewController().getReviewRecord(txtFieldStaffNumber.getText(), txtFieldYear.getText());
            if(reviewRecordToRead != null)
            {
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
            }else
            {
                showRecordDoesNotExistAlert(txtFieldStaffNumber.getText(), txtFieldYear.getText());
            }

        }

        if(isAmendMode)
        {

        }
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

    public void showReviewRecordAlreadyExists(String username, String year)
    {
        Alert reviewRecordAlreadyExists = new Alert(Alert.AlertType.INFORMATION);
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



