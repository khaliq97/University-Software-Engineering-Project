package project.Database.Review;

import project.Database.HR_Database.HRDatabaseController;

/**
 * Created by osamakhaliq on 20/03/17.
 */
public class ReviewController {

    HRDatabaseController hrDatabaseController;

    public ReviewController(HRDatabaseController hrDatabaseController)
    {
        this.hrDatabaseController = hrDatabaseController;
    }

    public int createReviewRecord(String year, String staffNumber, String name, String section, String  managerDirectorName,String secondManagerDirectName,
                                   String objectives, String achievements, String preview, String reviewComments, String recommendation )
    {
        int returnResult = 0;
        boolean reviewRecordExists = false;
        Review newRecord = new Review(year, staffNumber, name, section, managerDirectorName, secondManagerDirectName, objectives, achievements, preview, reviewComments, recommendation);

        for(Review review: hrDatabaseController.getHrDatabase().getArrayListReviews()) {
            if (!review.getStaffNumber().equals(staffNumber)) {
                if (!review.getYear().equals(year)) {
                    reviewRecordExists = false;
                } else {
                    reviewRecordExists = true;
                }

            }
        }

        if(!reviewRecordExists)
        {
            hrDatabaseController.createReviewRecord(newRecord);
            returnResult = 1;
        }else
        {
            returnResult = 0;
        }

        return returnResult;

    }

    public Review getReviewRecord(String username, String year)
    {
        Review reviewToReturn = null;
        for(Review review: hrDatabaseController.getHrDatabase().getArrayListReviews()) {
            if (review.getStaffNumber().equals(username) && review.getYear().equals(year))
            {
                reviewToReturn = review;
            }else
            {

            }
        }
        return reviewToReturn;
    }
}
