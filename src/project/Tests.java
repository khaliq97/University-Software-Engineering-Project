package project;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by osamakhaliq on 18/02/17.
 */
public class Tests
{
    LoginView loginView = new LoginView();

    @Test
    public void checkIfJSONFilePathLengthAboveZero()
    {

        assertNotEquals("jsonFilePath string length must be above 0", 0, loginView.getJsonFilePath().length());
    }


}
