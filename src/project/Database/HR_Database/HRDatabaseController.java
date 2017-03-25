package project.Database.HR_Database;

import javafx.scene.control.Alert;
import project.Database.Personal_Detail.PersonalDetail;
import project.Database.Review.Review;

import java.io.*;

/**
 * Created by Osama Khaliq
 * Version (03/03/2016)
 * Controller for the HRDatabase class
 * Resposbible for storing the file path, populating the hrDatabase ArrayList, writing to the file,
 * creating a PersonalDetail object and getting a PersonalDetail object.
 */
public class HRDatabaseController{

    private final String HR_DATABASE_FILE_PATH = "HR_Database.txt";
    HRDatabase hrDatabase;

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
     * signOffReview
     */

    public void resetPersonalDetailsArrayListForTest()
    {
        hrDatabase.getArrayListPersonalDetails().clear();
    }

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
     * Adds the passed in reviewRecord to the reviews ArrayList.
     * Writes to the the database.
     * @param reviewRecord reviewRecord object to add
     */
    public void createReviewRecord(Review reviewRecord)
    {

        hrDatabase.getArrayListReviews().add(reviewRecord);
        writeToDatabase();

    }


    /**
     * Gets a review object from a username and a year.
     * @param username username of review object
     * @param year year of review object
     * @return Review object that matches username and year
     */
    public Review getReviewRecord(String username, String year)
    {
        Review reviewToReturn = null;
        for(Review review: hrDatabase.getArrayListReviews()) {
            if (review.getStaffNumber().equals(username) && review.getYear().equals(year))
            {
                reviewToReturn = review;
            }else
            {

            }
        }
        return reviewToReturn;
    }

    /**
     * Sets a position in the reviews ArrayList in HRDatabaseController with the passed in review object.
     * Checks if it matches its staffNumber and year.
     * Writes it to the database.
     * @param review review object that will replace the existing
     * @return status of creating a review record and writing it to the database, 1 for success, 0 for failure
     */
    public int setReviewRecord(Review review) {
        int returnFlag = 0;
        int index = 0;
        for (Review reviewToCheck : hrDatabase.getArrayListReviews()) {
            if (reviewToCheck.getStaffNumber().equals(review.getStaffNumber()) && reviewToCheck.getYear().equals(review.getYear())) {
                if (!review.isSigned()) {
                    hrDatabase.getArrayListReviews().set(index, review);
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
