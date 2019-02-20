import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.fail;

/***************************
 * Project: tsp
 * Date: 19/02/2019
 * Author: Nicolas Favre
 * Description: 
 ***************************/

public class FileManagerTest {

    @Test
    public void readFileTest() {
        try {
            FileManager.readFile("");
            fail();
        } catch (FileNotFoundException e) {
            // Exception launched and test passed
        }
    }

}
