package project.Tests;
import org.junit.Test;
import project.Database.UserSession;
import project.Views.LoginView;

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

        assertEquals("Login should fail, when user is '111111', password is 'PASSWORD' and authorization is '1'", "USER_PASS_FAILURE", userSession.login("111111", "PASSWORD", 1));
    }

}
