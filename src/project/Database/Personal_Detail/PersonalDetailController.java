package project.Database.Personal_Detail;
import project.Database.HR_Database.HRDatabaseController;
/**
 * Created by osamakhaliq on 07/03/17.
 */
public class PersonalDetailController {

    HRDatabaseController hrDatabaseController;

    public PersonalDetailController(HRDatabaseController hrDatabaseController)
    {
       this.hrDatabaseController = hrDatabaseController;
    }

    public int createPersonalDetail(String username, String surname, String name, String dob, String address, String townCity,
                                    String county, String postCode, String telephoneNumber, String mobileNumber,
                                    String emergencyContact, String emergencyContactNumber) {

        boolean personalDetailExists = false;
        for (PersonalDetail personalDetail: hrDatabaseController.getHrDatabase().getArrayListPersonalDetails()) {

            if (!personalDetail.getUsername().equals(username)) {
                personalDetailExists = false;
            } else {
                personalDetailExists = true;
            }
        }

        if (!personalDetailExists) {
            PersonalDetail newPersonalDetail = new PersonalDetail();

            newPersonalDetail.setUsername(username);
            newPersonalDetail.setSurname(surname);
            newPersonalDetail.setName(name);
            newPersonalDetail.setDOB(dob);
            newPersonalDetail.setAddress(address);
            newPersonalDetail.setTownCity(townCity);
            newPersonalDetail.setCounty(county);
            newPersonalDetail.setPostcode(postCode);
            newPersonalDetail.setTelephoneNumber(telephoneNumber);
            newPersonalDetail.setMobileNumber(mobileNumber);
            newPersonalDetail.setEmergencyContactName(emergencyContact);
            newPersonalDetail.setEmergencyContactNumber(emergencyContactNumber);


            hrDatabaseController.createPersonalDetail(newPersonalDetail);
            return 1;


        } else {
            System.out.println("eijrier");
            return 0;
        }
    }
}
