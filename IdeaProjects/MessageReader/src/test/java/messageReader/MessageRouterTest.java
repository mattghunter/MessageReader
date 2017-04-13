package messageReader;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static messageReader.MessageReaderConstants.STATUS_PROCESSING_OUTPUT_CHANNEL;
import static messageReader.MessageReaderConstants.TIMER_PROCESSING_OUTPUT_CHANNEL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4ClassRunner.class)
public class MessageRouterTest {

    MessageRouter unit = new MessageRouter();


    @Test
    public void test_routeStatusMessage() throws Exception {
        Map<String,String> testMessage = getStatusMessage();

        List<String> actualChannels = unit.route(testMessage);

        assertEquals(1, actualChannels.size());
        assertTrue(actualChannels.contains(STATUS_PROCESSING_OUTPUT_CHANNEL));
    }

    @Test
    public void test_routeTimerMessage() throws Exception {
        Map<String,String> testMessage = getTimerMessage();

        List<String> actualChannels = unit.route(testMessage);

        assertTrue(actualChannels.contains(TIMER_PROCESSING_OUTPUT_CHANNEL));
    }

    Map<String,String> getStatusMessage(){
        Map<String,String> message = new HashMap<String, String>();

        message.put("EntityName", "STATUS");
        message.put("Status", "1");

        return message;
    }

    Map<String,String> getTimerMessage(){
        Map<String,String> message = new HashMap<String, String>();

        message.put("EntityName", "TIMER");
        message.put("Date", "11/11/11");
        message.put("Time", "11:11:11");

        return message;
    }

}