package messageReader;


import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.XMLStreamReader2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static messageReader.MessageReaderConstants.*;

public class FileToMapConverter {

    private Logger logger = LoggerFactory.getLogger(FileToMapConverter.class);

    private List<String> expectedEntries = Arrays.asList(ENTITY_NAME, STATUS);

    public FileToMapConverter() {
    }

    public Map<String, String> convert(Message incomingMessage) throws Exception {
        File incomingFile = (File) incomingMessage.getPayload();
        Map<String, String> message = new HashMap<>();
        message.put(START_TIME, Objects.toString(System.nanoTime()));

        String key;
        String value;
        String xmlString = convertFileToString(incomingFile);

        InputStream is = new ByteArrayInputStream(xmlString.getBytes(Charset.defaultCharset()));
        XMLInputFactory2 xmlInputFactory = (XMLInputFactory2) XMLInputFactory.newInstance();
        XMLStreamReader2 xmlStreamReader = (XMLStreamReader2) xmlInputFactory.createXMLStreamReader(is);

        while (xmlStreamReader.hasNext()) {
            int eventType = xmlStreamReader.next();
            if (eventType == XMLEvent.START_ELEMENT) {
                key = xmlStreamReader.getName().toString();
                if (xmlStreamReader.next() == XMLEvent.CHARACTERS && expectedEntries.contains(key)){
                    value = xmlStreamReader.getText();
                    message.put(key,value);
                }
            }
        }
        logger.info("MessageConverted: " + message.toString());
        message.put(END_CONVERSION_TIME, Objects.toString(System.nanoTime()));
        return message;
    }

    private String convertFileToString(File incomingFile) throws Exception {
        return new String(Files.readAllBytes(Paths.get(incomingFile.getPath())));
    }


}
