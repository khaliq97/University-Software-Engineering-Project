package project.Tests;
import org.junit.Test;
import project.Views.LoginView;

import static org.junit.Assert.*;

/**
 * Created by osamakhaliq on 18/02/17.
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
