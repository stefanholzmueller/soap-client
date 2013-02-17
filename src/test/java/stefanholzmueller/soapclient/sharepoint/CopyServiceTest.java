package stefanholzmueller.soapclient.sharepoint;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CopyServiceTest {

    private CopyService copyService;

    @BeforeMethod
    public void setUp() throws Exception {
        copyService = new CopyService();
    }

    @Test
    public void testname() throws Exception {
        copyService.copyIntoItems("sourceUrl1", null, null, null, null, null);
    }
}
