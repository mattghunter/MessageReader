package messageReader.monitor;


import messageReader.Notification;
import messageReader.NotificationPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static messageReader.MessageReaderConstants.ENTITY_NAME;
import static messageReader.MessageReaderConstants.STATUS;

public class StatusMessageMonitor  {

    private Logger logger = LoggerFactory.getLogger(StatusMessageMonitor.class);

    @Autowired
    public StatusMonitorStrategy statusMonitorStrategy;

    @Autowired
    public NotificationPublisher notificationPublisher;

    public void monitor(Map<String, String> message) {
        logger.debug(message.get(ENTITY_NAME) + " being monitored in the Status Monitor");

        if (message.containsKey(STATUS) && statusMonitorStrategy.isStatusInError(message)) {
            logger.info("-- CREATING NOTIFICATION: " + message.get(ENTITY_NAME) + " -- ERROR --");
            notificationPublisher.publish(new Notification(message));
        } else if (message.containsKey(STATUS) && !statusMonitorStrategy.isStatusInError(message)) {
            logger.info("-- CREATING NOTIFICATION: " + message.get(ENTITY_NAME) + " -- ACTIVE --");
            notificationPublisher.publishResolve(new Notification(message));
        } else {
            logger.error("--- Invalid Message Type Hit Monitor ---");
        }
    }
}
