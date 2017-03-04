package project.Database.HR_Database;

import project.Database.User.PersonalDetail;

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
        hrDatabase.getPersonalDetails().add(personalDetail);

        writeToDatabase();
    }

    /**
     * Gets PersonalDetail object from hrDatabase using userName as key
     * @param userName the user which the PersonalDetail object is gotten from
     * @return PersonalDetail object
     */
    public PersonalDetail getPersonalDetails(String userName)
    {
        PersonalDetail personalDetailReturn = null;
        for(PersonalDetail personalDetail: hrDatabase.getPersonalDetails())
        {

            if(personalDetail.getUserName().equals(userName))
            {
                personalDetailReturn = personalDetail;
            }
        }

        return personalDetailReturn;
    }
}
