package messageReader.util;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.io.File;

public class MessageSender {

    public MessageSender() {
    }

    public void sendMessages(MessageChannel messageChannel, String filePath) throws Exception {
        File[] files = new File(filePath).listFiles();
        for (File f : files) {
            messageChannel.send(new GenericMessage<>(f));
        }
    }
}
