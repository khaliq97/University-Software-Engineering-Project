package project.Controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import project.Views.CreateAmendReadReviewRecordView;

/**
 * Created by aman on 18/03/17.
 */
public class CreateAmendReadReviewRecordController {

    CreateAmendReadReviewRecordView createAmendViewReviewRecordView;

    @FXML
    private TextField txtFieldStaffNumber;

    @FXML
    private TextField txtFieldName;

    @FXML
    private TextField txtFieldsection;

    @FXML
    private TextField txtFIeldManagerDirectorName;

    @FXML
    private TextField txtSecondManagerDirectorName;

    @FXML
    private TextField txtFIeldObjectives;

    @FXML
    private TextField txtFieldAchievement;

    @FXML
    private  TextField txtFieldPreview;

    @FXML
    private TextField txtFIeldReviewComments;

    @FXML
    private ComboBox comboBoxRecommendation;

    @FXML
    private Button completeRecordButton;



    public CreateAmendReadReviewRecordController(CreateAmendReadReviewRecordView createAmendReadReviewRecordView) {
        this.createAmendViewReviewRecordView = createAmendReadReviewRecordView;
    }



    }



