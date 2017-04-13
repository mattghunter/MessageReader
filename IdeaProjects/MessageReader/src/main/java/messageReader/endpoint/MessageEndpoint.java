package messageReader.endpoint;

import messageReader.Notification;
import org.springframework.messaging.Message;

public interface MessageEndpoint {

    void handleMessage(Message<Notification> message) throws Exception;
}
