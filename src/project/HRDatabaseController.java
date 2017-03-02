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
        //populateHRDatabase();
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
            hrDatabase = (HRDatabase) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
