package messageReader;

import messageReader.monitor.StatusMessageMonitor;
import messageReader.monitor.StatusMonitorStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;

import java.util.HashMap;
import java.util.Map;

import static messageReader.MessageReaderConstants.ENTITY_NAME;
import static messageReader.MessageReaderConstants.STATUS;

@RunWith(JUnit4ClassRunner.class)
public class StatusMessageMonitorTest {


    @Autowired
    @Qualifier("OUTGOINGMESSAGECHANNEL")
    private MessageChannel messageChannel;

    private StatusMonitorStrategy statusMonitorStrategy;

    private NotificationPublisher notificationPublisher;

    private StatusMessageMonitor unit;

    @Before
    public void setUp(){
        statusMonitorStrategy = new StatusMonitorStrategy();
//        notificationPublisher = new NotificationPublisher();
//        unit = new StatusMessageMonitor(statusMonitorStrategy, notificationPublisher);
    }


    @Test
    public void test_monitorStatusMessageError() throws Exception {
        Map<String,String> testMessage = createStatusMessageWithCode("2");

//        boolean alerted = unit.monitor(testMessage);

//        assertTrue(alerted);
    }

    @Test
    public void test_monitorStatusMessageOK() throws Exception {
        Map<String,String> testMessage = createStatusMessageWithCode("1");

//        boolean alerted = unit.monitor(testMessage);

//        assertFalse(alerted);
    }

    @Test
    public void test_MonitorStatusMessageInvalid() throws Exception {
        Map<String,String> testMessage = new HashMap<>();
        testMessage.put("EntityName", "NAME");

//        boolean alerted = unit.monitor(testMessage);

//        assertFalse(alerted);
    }


    private Map<String,String> createStatusMessageWithCode(String code){
        Map<String,String> message = new HashMap<>();
        message.put(ENTITY_NAME, "STATUS");
        message.put(STATUS, code);
        return message;
    }
}