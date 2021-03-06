package project.Database.HR_Database;

import javafx.scene.control.Alert;
import project.Database.Personal_Detail.PersonalDetail;
import project.Database.Review.AnnualReviewRecord;

import java.io.*;

/**
 * Created by Osama Khaliq
 * Controller for the HRDatabase class
 * Responsible for storing the file path, populating the hrDatabase ArrayList, writing to the file,
 * creating a PersonalDetail object and getting a PersonalDetail object.
 *
 * @Author Osama Khaliq
 * @version (25/03/2017)
 */
public class HRDatabaseController{

    private final String HR_DATABASE_FILE_PATH = "HR_Database.txt";
    private HRDatabase hrDatabase;

    /**
     * Constructor for Class
     */
    public HRDatabaseController()
    {
        hrDatabase = new HRDatabase(this);
        populateHRDatabase();
    }

    /**
     * Returns hrDatabase class
     * @return HRDatabase class
     */
    public HRDatabase getHrDatabase() {
        return hrDatabase;
    }

    /**
     * Checks if HR_Database.txt File exists
     * @return true if file exists, false if not
     */
    public boolean checkIfHR_DatabaseFileExists()
    {
        File hr_DatabaseFile = new File(HR_DATABASE_FILE_PATH);
        if(hr_DatabaseFile.exists() && !hr_DatabaseFile.isDirectory())
        {
            return true;
        }else
        {
            showHR_DatabaseFileDoesNotExistAlert();
            System.exit(0);
            return false;
        }
    }

    /**
     * Reads the HR_Database.txt file and populates the hrDatabase ArrayList with its contents.
     */
    public void populateHRDatabase()
    {

            FileInputStream fileInputStream;
            ObjectInputStream objectInputStream;

            try {
                fileInputStream = new FileInputStream(HR_DATABASE_FILE_PATH);
                objectInputStream = new ObjectInputStream(fileInputStream);

                HRDatabase readHR_Database = (HRDatabase) objectInputStream.readObject();
                hrDatabase = readHR_Database;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


    }

    /**
     * Writes the hrDatabase ArrayList to HR_Database.txt
     */
    public void writeToDatabase()
    {
        if(checkIfHR_DatabaseFileExists())
        {
            FileOutputStream fileOutputStream;
            ObjectOutputStream objectOutputStream;
            try {
                fileOutputStream = new FileOutputStream(HR_DATABASE_FILE_PATH);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(hrDatabase);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else
        {

        }

        populateHRDatabase();

    }

    /**
     * Clears the personalDetails ArrayList for JUnit tests
     */
    public void resetPersonalDetailsArrayListForTest()
    {
        hrDatabase.getArrayListPersonalDetails().clear();
    }

    /**
     * Clears the reviews ArrayList for JUnit tests
     */
    public void resetReviewsArrayListForTest()
    {
        hrDatabase.getArrayListReviews().clear();
    }



    /**
     * Creates a new PersonalDetail object
     * Adds it to hrDatabase
     * Calls write method
     * @param personalDetail personalDetail object
     */
    public void createPersonalDetail(PersonalDetail personalDetail)
    {
        hrDatabase.getArrayListPersonalDetails().add(personalDetail);

        writeToDatabase();
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
        int returnFlag = 0;
        int index = 0;
        for(PersonalDetail personalDetailToCheck: hrDatabase.getArrayListPersonalDetails()) {
            if (personalDetailToCheck.getUsername().equals(personalDetail.getUsername()))
            {
                hrDatabase.getArrayListPersonalDetails().set(index, personalDetail);
                writeToDatabase();

                returnFlag =  1;
            }else
            {
                returnFlag =  0;
            }
            index++;
        }

        return returnFlag;
    }

    /**
     * Gets PersonalDetail object from hrDatabase using userName as key
     * @param username the user which the PersonalDetail object is gotten from
     * @return PersonalDetail object
     */
    public PersonalDetail getPersonalDetail(String username)
    {
        PersonalDetail personalDetailReturn = null;
        for(PersonalDetail personalDetail: getHrDatabase().getArrayListPersonalDetails())
        {

            if(personalDetail.getUsername().equals(username))
            {
                personalDetailReturn = personalDetail;
            }
        }

        return personalDetailReturn;
    }



    /**
     * Adds the passed in annualReviewRecordRecord to the reviews ArrayList.
     * Writes to the the database.
     * @param annualReviewRecordRecord annualReviewRecordRecord object to add
     */
    public void createReviewRecord(AnnualReviewRecord annualReviewRecordRecord)
    {

        hrDatabase.getArrayListReviews().add(annualReviewRecordRecord);
        writeToDatabase();

    }


    /**
     * Gets a review object from a username and a year.
     * @param username username of review object
     * @param year year of review object
     * @return AnnualReviewRecord object that matches username and year
     */
    public AnnualReviewRecord getReviewRecord(String username, String year)
    {
        AnnualReviewRecord annualReviewRecordToReturn = null;
        for(AnnualReviewRecord annualReviewRecord : hrDatabase.getArrayListReviews()) {
            if (annualReviewRecord.getStaffNumber().equals(username) && annualReviewRecord.getYear().equals(year))
            {
                annualReviewRecordToReturn = annualReviewRecord;
            }else
            {

            }
        }
        return annualReviewRecordToReturn;
    }

    /**
     * Sets a position in the reviews ArrayList in HRDatabaseController with the passed in annualReviewRecord object.
     * Checks if it matches its staffNumber and year.
     * Writes it to the database.
     * @param annualReviewRecord annualReviewRecord object that will replace the existing
     * @return status of creating a annualReviewRecord record and writing it to the database, 1 for success, 0 for failure
     */
    public int setReviewRecord(AnnualReviewRecord annualReviewRecord) {
        int returnFlag = 0;
        int index = 0;
        for (AnnualReviewRecord annualReviewRecordToCheck : hrDatabase.getArrayListReviews()) {
            if (annualReviewRecordToCheck.getStaffNumber().equals(annualReviewRecord.getStaffNumber()) && annualReviewRecordToCheck.getYear().equals(annualReviewRecord.getYear())) {
                if (!annualReviewRecord.isSigned()) {
                    hrDatabase.getArrayListReviews().set(index, annualReviewRecord);
                    writeToDatabase();

                    returnFlag = 1;
                }

            } else {
                returnFlag = 0;
            }
            index++;
        }

        return returnFlag;
    }


    /**
     * Shows Alert Box if HR_Database file does not exist
     */
    public void showHR_DatabaseFileDoesNotExistAlert()
    {

        Alert hr_DatabaseFileDoesNotExist = new Alert(javafx.scene.control.Alert.AlertType.ERROR);
        hr_DatabaseFileDoesNotExist.setHeaderText(HR_DATABASE_FILE_PATH + " does not exist, application exiting");
        hr_DatabaseFileDoesNotExist.show();
    }
}
