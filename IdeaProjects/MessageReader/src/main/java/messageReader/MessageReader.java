package messageReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class MessageReader {

    public static void main (String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Logger logger = LoggerFactory.getLogger(MessageReader.class);

        logger.info("STARTING UP MESSAGE READER");
        SpringApplication.run(MessageReader.class, args);
    }
}
