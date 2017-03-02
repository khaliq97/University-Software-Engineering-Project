package project;

import project.User.User;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by osamakhaliq on 02/03/17.
 */
public class HRDatabase implements Serializable{

    private final String HR_DATABASE_FILE_PATH = "HR_Database.txt";
    private ArrayList<PersonalDetail> personalDetails;

    public HRDatabase(HRDatabaseController hrDatabaseController)
    {
        personalDetails = new ArrayList<>();
    }


    public void createPersonalDetail(PersonalDetail personalDetail)
    {
        PersonalDetail personalDetailToAdd = new PersonalDetail();
        personalDetails.add(personalDetailToAdd);

        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fileOutputStream = new FileOutputStream(HR_DATABASE_FILE_PATH);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getPersonalDetails(User user)
    {

    }

}
