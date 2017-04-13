package messageReader;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Router;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static messageReader.MessageReaderConstants.*;

public class MessageRouter  {

    private List<String> routingChannels;
    private Logger logger = LoggerFactory.getLogger(MessageRouter.class);

    @Router
    public List<String> route(Map<String, String> payload) {
        routingChannels = new ArrayList<>();
        logger.debug("Message Received " + payload.toString());

        if (payload.containsKey(STATUS)) {
            routingChannels.add(STATUS_PROCESSING_OUTPUT_CHANNEL);
        }

        if (payload.containsKey(DATE) && payload.containsKey(TIME)) {
            routingChannels.add(TIMER_PROCESSING_OUTPUT_CHANNEL);
        }

        logger.debug("Routing to channels: " + routingChannels.toString());
        return routingChannels;
    }

}
