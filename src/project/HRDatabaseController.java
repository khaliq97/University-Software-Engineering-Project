package project;

import java.io.*;

/**
 * Created by osamakhaliq on 02/03/17.
 */
public class HRDatabaseController{

    private final String HR_DATABASE_FILE_PATH = "HR_Database.txt";
    HRDatabase hrDatabase;

    public HRDatabaseController()
    {
        hrDatabase = new HRDatabase(this);
        populateHRDatabase();
    }

    public HRDatabase getHrDatabase() {
        return hrDatabase;
    }

    public void setHrDatabase(HRDatabase hrDatabase) {
        this.hrDatabase = hrDatabase;
    }

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

    public void createPersonalDetail(PersonalDetail personalDetail)
    {
        PersonalDetail personalDetailToAdd = new PersonalDetail();
        hrDatabase.getPersonalDetails().add(personalDetail);

        writeToDatabase();
    }

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
