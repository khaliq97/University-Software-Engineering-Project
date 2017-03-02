package project.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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

    }
}
