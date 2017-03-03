package project.Database.HR_Database;

import project.Database.User.PersonalDetail;

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

    public ArrayList<PersonalDetail> getPersonalDetails()
    {
        return personalDetails;
    }



}
