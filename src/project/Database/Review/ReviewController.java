package project.Database.Review;

import project.Database.HR_Database.HRDatabaseController;

/**
 * Created by Osama Khaliq
 *
 * Responsible for creating, getting and setting a AnnualReviewRecord object in the
 * reviews ArrayList in HRDatabase.
 *
 * @Author Osama Khaliq
 * @version (25/03/2017)
 */
public class ReviewController {

    private HRDatabaseController hrDatabaseController;

    /**
     * Class constructor
     * @param hrDatabaseController HRDatabaseController class
     */
    public ReviewController(HRDatabaseController hrDatabaseController)
    {
        this.hrDatabaseController = hrDatabaseController;
    }

    /**
     * Creates a new AnnualReviewRecord object with data from controls in CreateAmendReadReviewRecordController.
     * If the review object does not exist then it adds it to the reviews ArrayList in HRDatabaseController.
     *
     * @param year year from txtFieldYear
     * @param staffNumber staffNumber from txtFieldStaffNumber
     * @param name name from txtFieldName
     * @param section section from txtFieldSection
     * @param managerDirectorName manager or director name from txtFieldManagerDirectorName
     * @param secondManagerDirectorName second manager or director name from txtFieldSecondManagerDirectName
     * @param objectives objectives from txtFieldObjectives
     * @param achievements achievements from txtFieldAchievements
     * @param preview preview from txtFieldPreview
     * @param reviewComments reviewComments from txtFieldReviewComments
     * @param recommendation recommendation from txtFieldRecommendation
     * @param revieweeSignature revieweeSignature from txtFieldRevieweeSignature
     * @param managerDirectorSignature managerDirectorSignature from txtFieldManagerDirectorSignature
     * @param secondReviewerSignature secondReviewerSignature from txtFieldSecondReviewerSignature
     * @param dateSigned dateSigned from txtFieldDateSigned
     * @param signed signed from checkBoxSigned
     * @return status of creating a review record, 1 for success, 0 for failure
     */
    public int createReviewRecord(String year, String staffNumber, String name, String section, String  managerDirectorName,String secondManagerDirectorName,
                                   String objectives, String achievements, String preview, String reviewComments, String recommendation, String revieweeSignature, String managerDirectorSignature, String secondReviewerSignature, String dateSigned, boolean signed) {
        int returnFlag = 0;
        boolean reviewRecordExists = false;
        AnnualReviewRecord newRecord = new AnnualReviewRecord(year, staffNumber, name, section, managerDirectorName, secondManagerDirectorName, objectives, achievements, preview, reviewComments, recommendation, revieweeSignature, managerDirectorSignature, secondReviewerSignature, dateSigned, signed);

        for (AnnualReviewRecord annualReviewRecord : hrDatabaseController.getHrDatabase().getArrayListReviews()) {

                if (annualReviewRecord.getStaffNumber().equals(staffNumber)) {
                    if (!annualReviewRecord.getYear().equals(year)) {
                        reviewRecordExists = false;

                    } else {
                        reviewRecordExists = true;
                    }

                }
        }

        if (!reviewRecordExists) {
            hrDatabaseController.createReviewRecord(newRecord);
            returnFlag = 1;
        } else {
            returnFlag = 0;
        }

        return returnFlag;
    }

    /**
     * Gets a review object from a username and a year.
     * @param username username of review object
     * @param year year of review object
     * @return AnnualReviewRecord object that matches username and year
     */
    public AnnualReviewRecord getReviewRecord(String username, String year)
    {

        return hrDatabaseController.getReviewRecord(username, year);
    }

    /**
     * Sets a position in the reviews ArrayList in HRDatabaseController with the passed in annualReviewRecord object.
     * Checks if it matches its staffNumber and year.
     * Writes it to the database.
     * @param annualReviewRecord annualReviewRecord object that will replace the existing
     * @return status of creating a annualReviewRecord record and writing it to the database, 1 for success, 0 for failure
     */
    public int amendReviewRecord(AnnualReviewRecord annualReviewRecord)
    {
      return hrDatabaseController.setReviewRecord(annualReviewRecord);
    }
}
