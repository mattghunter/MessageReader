package messageReader.endpoint;

import messageReader.Notification;
import org.springframework.messaging.Message;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static messageReader.MessageReaderConstants.*;


public class OutputToCSVExporter implements MessageEndpoint {

    public OutputToCSVExporter() throws IOException {
    }

    @Override
    public void handleMessage(Message<Notification> message) throws IOException {
        Map<String, String> messageMap = message.getPayload().getMessageDetails();
        messageMap.put(END_TIME, message.getPayload().getEndProcessingTime());
        if (hasStartAndEndTimes(messageMap)) {
            exportToCsv(messageMap);
        }
    }

    private void exportToCsv(Map<String, String> message) throws IOException {
        FileWriter fileWriter = new FileWriter(RESULTS_FILE_PATH + RESULTS_FILE_NAME, true);
        BufferedWriter bw = new BufferedWriter(fileWriter);

        bw.append(message.get(ENTITY_NAME)).append(DELIMETER)
                .append(message.get(START_TIME)).append(DELIMETER)
                .append(message.get(END_CONVERSION_TIME)).append(DELIMETER)
                .append(message.get(END_TIME)).append(DELIMETER)
                .append(message.get(STATUS));
        bw.newLine();

        bw.close();
        fileWriter.close();
    }

    private boolean hasStartAndEndTimes(Map<String, String> message) {
        return message.containsKey(START_TIME) && message.containsKey(END_TIME);
    }


}
