package messageReader.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static messageReader.MessageReaderConstants.FILE_EXTENSION;
import static messageReader.MessageReaderConstants.FILE_PATH;
import static messageReader.MessageReaderConstants.FILE_PREFIX;


public class MessageGenerator {


    private static final int MESSAGE_VOLUME = 100000;


    public static void main (String[] args) throws IOException {
        Logger logger = LoggerFactory.getLogger(MessageGenerator.class);

        clearDirectory(logger);

        for(int i = 0; i < MESSAGE_VOLUME; i++){
            generateXml(i, logger);
        }
    }

    private static void clearDirectory(Logger logger){
        logger.info("Gathering Files");
        File[] files = new File(FILE_PATH).listFiles();
        if (files!=null){
            logger.info("Clearing Directory");
            for (File f : files){
                if (!f.isDirectory()){
                    f.delete();
                }
            }
        }
    }

    private static Document createNewDocument(int messageNumber){
        Element root = new Element("StatusMessage");
        Document doc = new Document();
        Element entityName = new Element("EntityName");
        entityName.addContent(FILE_PREFIX + Integer.toString(messageNumber));
        Element status = new Element("Status");
        status.addContent(Integer.toString((Math.random() <= 0.5) ? 1 : 2));

        root.addContent(entityName);
        root.addContent(status);

        doc.setRootElement(root);

        return doc;
    }

    private static void generateXml(int i, Logger logger) throws IOException {

        Document doc = createNewDocument(i);

        XMLOutputter outputter = new XMLOutputter();
        outputter.setFormat(Format.getPrettyFormat());

        String filename = FILE_PREFIX + i + FILE_EXTENSION;

        outputter.output(doc, new FileWriter(new File(FILE_PATH + filename)));
        logger.info("File Created with name: " + filename);

        }
}
