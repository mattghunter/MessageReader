package messageReader.monitor;


import java.util.Map;

import static messageReader.MessageReaderConstants.STATUS;

public class StatusMonitorStrategy {

    public StatusMonitorStrategy() {
    }

    boolean isStatusInError(Map<String,String> message){
        return message.get(STATUS).equalsIgnoreCase("2");
    }
}
