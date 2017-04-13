package messageReader.performanceTest;

import messageReader.util.MessageSender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

import static messageReader.MessageReaderConstants.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class PerformanceTest {


    MessageSender messageSender;
    Logger logger;

    @Autowired
    @Qualifier("InputToConverterChannel")
    public DirectChannel converterInputChannel;

    @Before
    public void setUp() throws Exception {
        messageSender = new MessageSender();
        logger = LoggerFactory.getLogger(PerformanceTest.class);
    }

    @Test
//    @Ignore
    public void test_PerformanceJavaComponents() throws Exception {
        removeExistingResultsFile();
        messageSender.sendMessages(converterInputChannel, FILE_PATH);
    }

    private void removeExistingResultsFile(){
        File file = new File(RESULTS_FILE_PATH + RESULTS_FILE_NAME);
        file.delete();
    }
}
