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

    /**
     * Gets PersonalDetail object from hrDatabase using userName as key
     * @param username the user which the PersonalDetail object is gotten from
     * @return PersonalDetail object
     */
    public PersonalDetail getPersonalDetail(String username)
    {
        PersonalDetail personalDetailReturn = null;
        for(PersonalDetail personalDetail: hrDatabaseController.getHrDatabase().getArrayListPersonalDetails())
        {

            if(personalDetail.getUsername().equals(username))
            {
                personalDetailReturn = personalDetail;
            }
        }

        return personalDetailReturn;
    }

    public int setPersonalDetail(PersonalDetail personalDetail)
    {
        int returnFlag = 0;
        int index = 0;
        for(PersonalDetail personalDetailToCheck: hrDatabaseController.getHrDatabase().getArrayListPersonalDetails()) {
            if (personalDetailToCheck.getUsername().equals(personalDetail.getUsername()))
            {
                hrDatabaseController.getHrDatabase().getArrayListPersonalDetails().set(index, personalDetail);
                hrDatabaseController.writeToDatabase();

                returnFlag =  1;
            }else
            {
                returnFlag =  0;
            }
            index++;
        }

        return returnFlag;
    }
}
