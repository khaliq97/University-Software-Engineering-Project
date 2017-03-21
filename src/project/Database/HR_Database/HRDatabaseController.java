package project.Database.HR_Database;

import javafx.scene.control.Alert;
import project.Database.Personal_Detail.PersonalDetail;

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
     * @return
     */
    public HRDatabase getHrDatabase() {
        return hrDatabase;
    }

    /**
     * Checks if HR_Database.txt File exists
     * @return
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

    }

    /**
     * Creates a new PersonalDetail object
     * Adds it to hrDatabase
     * Calls write method
     * @param personalDetail personalDetail object
     */
    public void createPersonalDetail(PersonalDetail personalDetail)
    {
        PersonalDetail personalDetailToAdd = new PersonalDetail();
        hrDatabase.getArrayListPersonalDetails().add(personalDetail);

        writeToDatabase();
    }

    /**
     * Gets PersonalDetail object from hrDatabase using userName as key
     * @param username the user which the PersonalDetail object is gotten from
     * @return PersonalDetail object
     */
    public PersonalDetail getPersonalDetail(String username)
    {
        PersonalDetail personalDetailReturn = null;
        for(PersonalDetail personalDetail: hrDatabase.getArrayListPersonalDetails())
        {

            if(personalDetail.getUsername().equals(username))
            {
                personalDetailReturn = personalDetail;
            }
        }

        return personalDetailReturn;
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
