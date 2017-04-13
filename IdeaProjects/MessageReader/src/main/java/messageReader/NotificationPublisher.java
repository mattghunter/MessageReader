package messageReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import java.util.Objects;

public class NotificationPublisher {


    @Autowired
    @Qualifier("PublisherToOutputChannel")
    public DirectChannel outgoingChannel;

//    public NotificationPublisher(DirectChannel outgoingChannel) {
//        this.outgoingChannel = outgoingChannel;
//    }

    public boolean publish(Notification notification) {
        return outgoingChannel.send(wrapMessage(notification, true));
    }

    public boolean publishResolve(Notification notification) {
        return outgoingChannel.send(wrapMessage(notification, false));
    }

    Message wrapMessage(Notification notification, boolean active) {
        Message<Notification> outgoingMessage;
        notification.setActive(active);
        notification.setEndProcessingTime(Objects.toString(System.nanoTime()));
        outgoingMessage = new GenericMessage<>(notification);
        return outgoingMessage;
    }
}
