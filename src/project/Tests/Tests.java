package project.Tests;
import org.junit.Test;
import project.Database.User_Database.UserSession;

import static org.junit.Assert.*;

/**
 * Created by Osama Khaliq
 * Version (19/02/2017)
 * Test class
 */
public class Tests
{

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

}
