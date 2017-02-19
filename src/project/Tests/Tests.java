package project.Tests;
import org.junit.Test;
import project.Views.LoginView;

import static org.junit.Assert.*;

/**
 * Created by Osama Khaliq
 * Version (19/02/2017)
 * Test class
 * Incomplete
 */
public class Tests
{
    private LoginView loginView = new LoginView();

    @Test
    public void checkIfJSONFilePathLengthAboveZero()
    {

        assertNotEquals("jsonFilePath string length must be above 0", 0, loginView.getJsonFilePath().length());
    }


}
