package messageReader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.messaging.Message;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.Map;

import static messageReader.MessageReaderConstants.ENTITY_NAME;
import static messageReader.MessageReaderConstants.STATUS;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class NotificationPublisherTest {

    private NotificationPublisher unit = new NotificationPublisher();

    private Notification notification;

    private Map<String, String> message;

    @Before
    public void setUp() throws Exception {
        message = new HashMap<>();
        notification = new Notification(message);
    }

    @Test
    public void test_wrapMessageForTrueNotification() throws Exception {
        message = generateMessageWithCode("2");
        notification = new Notification(message);

        Message published = unit.wrapMessage(notification, true);

        assertEquals(published.getPayload(), notification);
    }

    @Test
    public void p09() throws Exception {
        message = generateMessageWithCode("2");
        notification = new Notification(message);

        Message published = unit.wrapMessage(notification, false);

        assertEquals(published.getPayload(), notification);
    }

    private Map<String,String> generateMessageWithCode(String statusCode) {
        Map<String, String> message = new HashMap<>();
        message.put(ENTITY_NAME, "EntityName");
        message.put(STATUS, statusCode);
        return message;
    }




}