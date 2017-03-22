package project.Database.HR_Database;

import project.Database.Personal_Detail.PersonalDetail;
import project.Database.Review.Review;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Osama Khaliq
 * Version (03/03/2016)
 * Class stores an ArrayList of PersonalDetail objects
 * Entire class is written to a file as it is Serializable.
 */
public class HRDatabase implements Serializable{

    private ArrayList<PersonalDetail> personalDetails;

    private ArrayList<Review> reviews;

    /**
     * Constructor for Class
     * @param hrDatabaseController hrDatabaseController class
     */
    public HRDatabase(HRDatabaseController hrDatabaseController)
    {
        personalDetails = new ArrayList<>();
        reviews = new ArrayList<>();
    }

    /**
     * Returns personalDetails ArrayList
     * @return personalDetails
     */
    public ArrayList<PersonalDetail> getArrayListPersonalDetails()
    {
        return personalDetails;
    }


    public ArrayList<Review> getArrayListReviews()
    {
        return reviews;
    }


}
