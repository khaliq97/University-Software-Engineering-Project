package project.Controllers;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import project.Views.CreateAmendReadReviewRecordView;

/**
 * Created by aman on 18/03/17.
 */
public class CreateAmendReadReviewRecordController {

    CreateAmendReadReviewRecordView createAmendViewReviewRecordView;

    @FXML
    private TextField staffNumberfld;

    @FXML
    private TextField nameFld;

    @FXML
    private TextField sectionFld;

    @FXML
    private TextField mandirFld;

    @FXML
    private TextField secondmandirFld;

    @FXML
    private TextField objFLd;

    @FXML
    private TextField achFld;

    @FXML
    private  TextField previewFld;

    @FXML
    private TextField reviewcommentsFld;

    @FXML
    private ComboBox recommendationCbox;


    public CreateAmendReadReviewRecordController(CreateAmendReadReviewRecordView createAmendReadReviewRecordView) {
        this.createAmendViewReviewRecordView = createAmendReadReviewRecordView;
    }



}
