package project.Tests;
import org.junit.Test;
import project.Database.HR_Database.HRDatabaseController;
import project.Database.Personal_Detail.PersonalDetail;
import project.Database.Personal_Detail.PersonalDetailController;
import project.Database.Review.AnnualReviewRecord;
import project.Database.Review.ReviewController;
import project.Database.User_Database.UserSession;

import static org.junit.Assert.*;

/**
 * Created by Osama Khaliq
 *
 * Implements JUnit tests to cover all functionality
 * Log in, log out, create personal detail, amend personal detail, readPersonalDetail,
 * createReviewRecord, amendReviewRecord, readReviewRecord and their variants.
 *
 * @Author Osama Khaliq
 * @version (25/03/2017)
 */
public class Tests
{
    private HRDatabaseController hrDatabaseController;
    private PersonalDetailController personalDetailController;
    private ReviewController reviewController;

    public Tests()
    {
        hrDatabaseController = new HRDatabaseController();
        personalDetailController =  new PersonalDetailController(hrDatabaseController);
        reviewController = new ReviewController(hrDatabaseController);
        hrDatabaseController.resetPersonalDetailsArrayListForTest();
        hrDatabaseController.resetReviewsArrayListForTest();

        createTestPersonalDetail();
        createTestReviewRecord();

    }

    public void createTestPersonalDetail()
    {
        personalDetailController.createPersonalDetail("111111", "Taylor", "Peter", "02/02/1995", "61 Beverley Road", "Canterbury", "Kent", "CT2 7EW",
                "01604954332", "07435945843", "Lewis Taylor", "07485938457");
    }

    public void createTestReviewRecord()
    {
        reviewController.createReviewRecord("2015", "111111", "Peter Taylor", "Section", "Manager\\Director Name", "Second Manager\\Director Name",
                "Objectives", "Achievements", "Preview", "AnnualReviewRecord Comments", "Recommendation", "Reviewee Signature",
                "Manager\\Director Signature", "Second Reviewer Signature", "01/01/2017", false);
    }

    @Test
    public void correctDetailsLoginTest()
    {
        UserSession userSession = new UserSession();

        assertEquals("Login should succeed, when user is '111111', password is 'pass' and authorization is '1'", "SUCCESS", userSession.login("111111", "pass", 1));
    }

    @Test
    public void incorrectAuthorizationLoginTest()
    {
        UserSession userSession = new UserSession();

        assertEquals("Login should fail, when user is '111111', password is 'pass' and authorization is '2'", "AUTH_FAILURE", userSession.login("111111", "pass", 2));
    }

    @Test
    public void notFoundUserLoginTest()
    {
        UserSession userSession = new UserSession();

        assertEquals("Login should fail, when user is '432436', password is 'pass' and authorization is '1'", "USER_PASS_FAILURE", userSession.login("432436", "pass", 1));
    }

    @Test
    public void incorrectPasswordLoginTest()
    {
        UserSession userSession = new UserSession();

        assertEquals("Login should fail, when user is '111111', password is 'wrongPassword' and authorization is '1'", "USER_PASS_FAILURE", userSession.login("111111", "wrongPassword", 1));
    }

    @Test
    public void isUserLoggedInTest()
    {
        UserSession userSession = new UserSession();
        userSession.login("111111", "pass", 1);
        assertNotNull("User should not be Null", userSession.getUser());
    }

    @Test
    public void isUserLoggedIncorrectDetailsInTest()
    {
        UserSession userSession = new UserSession();
        userSession.login("111111", "wrongPassword", 1);
        assertNull("User should be Null", userSession.getUser());
    }

    @Test
    public void hasUserLoggedOutTest()
    {
        UserSession userSession = new UserSession();
        userSession.login("111111", "pass", 1);
        userSession.logout();
        assertEquals("User isLogged should be False", false,  userSession.getUser().isLoggedIn());

    }


    @Test
    public void createPersonalDetailNotNullTest()
    {
        PersonalDetail testPersonal = personalDetailController.getPersonalDetail("111111");

        assertNotNull(testPersonal);
    }


    @Test
    public void createPersonalDetailWithExistingUserNameTest()
    {

        int testResult = personalDetailController.createPersonalDetail("111111", "Taylor", "Peter", "02/02/1995", "61 Beverley Road", "Canterbury", "Kent", "CT2 7EW",
                "01604954332", "07435945843", "Lewis Taylor", "07485938457");

        assertEquals("Method should return '0' for failure as Personal Detail with username '1111111' does exist", 0, testResult);
    }

    @Test
    public void amendPersonalDetailTest()
    {
        personalDetailController.getPersonalDetail("111111").setEmergencyContactName("David Wilson");

        assertEquals("Emergency contact name of Personal Detail for username '111111' must be 'David Wilson'", "David Wilson", personalDetailController.getPersonalDetail("111111").getEmergencyContactName());
    }

    @Test
    public void readPersonalDetailTest()
    {

        assertEquals("Address of Personal Detail for username 111111 must be '61 Beverley Road",  "61 Beverley Road", personalDetailController.getPersonalDetail("111111").getAddress());

    }

    @Test
    public void createReviewRecordNotNullTest()
    {
        assertNotNull(reviewController.getReviewRecord("111111", "2015"));
    }


    @Test
    public void createReviewRecordWithExistingStaffNumberDifferentYear()
    {
        int testResult = reviewController.createReviewRecord("2016", "111111", "Peter Taylor", "Section", "Manager\\Director Name", "Second Manager\\Director Name",
                "Objectives", "Achievements", "Preview", "AnnualReviewRecord Comments", "Recommendation", "Reviewee Signature",
                "Manager\\Director Signature", "Second Reviewer Signature", "01/01/2017", false);

        assertEquals("Creating a new review record with the username '111111' at year '2016' should return '1' for success", 1, testResult);
    }


    @Test
    public void createReviewRecordWithExistingStaffNumberAndYearTest()
    {
        int testResult = reviewController.createReviewRecord("2015", "111111", "Peter Taylor", "Section", "Manager\\Director Name", "Second Manager\\Director Name",
                "Objectives", "Achievements", "Preview", "AnnualReviewRecord Comments", "Recommendation", "Reviewee Signature",
                "Manager\\Director Signature", "Second Reviewer Signature", "01/01/2017", false);

        assertEquals("Method should return '0' for failure as AnnualReviewRecord Record for username '1111111' and year '2015' does exist", 0, testResult);
    }

    @Test
    public void amendReviewRecordTest()
    {
        reviewController.getReviewRecord("111111", "2015").setObjectives("Amend Objectives Test");

        assertEquals("Objectives of ReviewRecord for username '111111' at year '2015' must be 'Amend Objectives Test",  "Amend Objectives Test", reviewController.getReviewRecord("111111", "2015").getObjectives());
    }

    @Test
    public void readReviewRecordTest()
    {
        assertEquals("Achievements of AnnualReviewRecord Record for username '111111' at year '2015' must be 'Achievements",  "Achievements", reviewController.getReviewRecord("111111", "2015").getAchievement());
    }

    @Test
    public void amendNonSignedOffReviewRecordTest()
    {
        AnnualReviewRecord testAnnualReviewRecord = reviewController.getReviewRecord("111111", "2015");

        assertEquals("AnnualReviewRecord Record for username '111111' at year '2015' should be amendable and should return 1 for success", 1 ,reviewController.amendReviewRecord(testAnnualReviewRecord));

    }

    @Test
    public void amendSignedOffReviewRecordTest()
    {
        reviewController.getReviewRecord("111111", "2015").setSigned(true);
        AnnualReviewRecord testAnnualReviewRecord = reviewController.getReviewRecord("111111", "2015");

        assertEquals("AnnualReviewRecord Record for username '111111' at year '2015' should not be amendable and should return 0 for failure", 0 ,reviewController.amendReviewRecord(testAnnualReviewRecord));

    }



}
