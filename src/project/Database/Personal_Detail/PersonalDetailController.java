package project.Database.Personal_Detail;
import project.Database.HR_Database.HRDatabaseController;
/**
 * Created by Osama Khaliq
 * Version (23/03/2016)
 *
 * Responsible for creating, getting and setting Personal Details into and from the
 * personalDetails ArrayList in HRDatabase.
 */
public class PersonalDetailController {

    HRDatabaseController hrDatabaseController;

    /**
     * Class constructor
     * @param hrDatabaseController HRDatabaseController class
     */
    public PersonalDetailController(HRDatabaseController hrDatabaseController)
    {
       this.hrDatabaseController = hrDatabaseController;
    }

    /**
     * Creates a new PersonalDetail object with the parameter data from the createPersonalDetailsController class
     * @param username username value
     * @param surname surname value
     * @param name name value
     * @param dob dob value
     * @param address address value
     * @param townCity town or city value
     * @param county county value
     * @param postCode postcode value
     * @param telephoneNumber telephone number value
     * @param mobileNumber mobile number value
     * @param emergencyContact emergency contact value
     * @param emergencyContactNumber emergency contact number value
     * @return status of creating a review record, 1 for success, 0 for failure
     */
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
            return 0;
        }
    }

    /**
     * Gets PersonalDetail object from hrDatabase using userName as key
     * @param username the user which the PersonalDetail object is gotten from
     * @return PersonalDetail object
     */
    public PersonalDetail getPersonalDetail(String username)
    {
       return hrDatabaseController.getPersonalDetail(username);
    }

    /**
     * Sets a position in the personalDetails ArrayList in HRDatabaseController with the passed in personalDetail object.
     * Checks if it matches its username.
     * Writes it to the database.
     * @param personalDetail personalDetail object that will replace the existing
     * @return status of creating a personalDetail and writing it to the database, 1 for success, 0 for failure
     */
    public int amendPersonalDetail(PersonalDetail personalDetail)
    {
        int returnFlag = hrDatabaseController.amendPersonalDetail(personalDetail);

        return returnFlag;
    }
}
