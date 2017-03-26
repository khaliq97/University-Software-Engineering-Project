package project.Database.HR_Database;

import project.Database.Personal_Detail.PersonalDetail;
import project.Database.Review.AnnualReviewRecord;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Osama Khaliq
 * Class stores an ArrayList of PersonalDetail objects
 * Entire class is written to a file as it is Serializable.
 *
 * @Author Osama Khaliq
 * @version (25/03/2017)
 */
public class HRDatabase implements Serializable{

    private ArrayList<PersonalDetail> personalDetails;

    private ArrayList<AnnualReviewRecord> annualReviewRecords;

    /**
     * Constructor for Class
     * @param hrDatabaseController hrDatabaseController class
     */
    public HRDatabase(HRDatabaseController hrDatabaseController)
    {
        personalDetails = new ArrayList<>();
        annualReviewRecords = new ArrayList<>();
    }

    /**
     * Returns personalDetails ArrayList
     * @return personalDetails
     */
    public ArrayList<PersonalDetail> getArrayListPersonalDetails()
    {
        return personalDetails;
    }


    /**
     * Returns annualReviewRecords ArrayList
     * @return annualReviewRecords
     */
    public ArrayList<AnnualReviewRecord> getArrayListReviews()
    {
        return annualReviewRecords;
    }


}
