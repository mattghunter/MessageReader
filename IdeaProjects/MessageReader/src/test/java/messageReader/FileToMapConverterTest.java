package messageReader;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.messaging.support.GenericMessage;

import java.io.File;
import java.net.URL;
import java.util.Map;

import static messageReader.MessageReaderConstants.ENTITY_NAME;
import static messageReader.MessageReaderConstants.STATUS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(JUnit4ClassRunner.class)
public class FileToMapConverterTest {

    FileToMapConverter unit;

    @Before
    public void setUp() throws Exception {
        unit = new FileToMapConverter();
    }

    @Test
    public void test_convertValidStatusXML() throws Exception {
        URL url = Thread.currentThread().getContextClassLoader().getResource("messageReader/validTEST_STATUS_00.xml");
        File file = new File(url.getPath());
        assertTrue(file.exists());

        Map<String, String> actualConversion = unit.convert(new GenericMessage<>(file));

        assertEquals(4, actualConversion.size());
        assertEquals("STATUS_00", actualConversion.get(ENTITY_NAME));
        assertEquals("1", actualConversion.get(STATUS));
    }

//    @Test
//    public void test_convertInvalidStatusXML()throws Exception {
//        URL url = Thread.currentThread().getContextClassLoader().getResource("messageReader/validTEST_STATUS_00.xml");
//        File file = new File(url.getPath());
//        assertTrue(file.exists());
//
//        Map<String, String> actualConversion = unit.convert(file);
//
//
//    }

}