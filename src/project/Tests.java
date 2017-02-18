package project;
import org.json.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by osamakhaliq on 18/02/17.
 */
public class Tests
{
    Login login = new Login();

    @Test
    public void checkIfJSONFilePathLengthAboveZero()
    {

        assertNotEquals("jsonFilePath string length must be above 0", 0, login.getJsonFilePath().length());
    }


}
