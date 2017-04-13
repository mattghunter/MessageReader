package messageReader;

public class MessageReaderConstants {

    public MessageReaderConstants() {
    }

    static final String DATE = "Date";
    static final String TIME = "Time";
    public static final String STATUS = "Status";
    public static final String ENTITY_NAME = "EntityName";

    // For Message Sender
    public static final String FILE_PATH = "..\\MessageReader\\xmlFiles\\";
    public static final String FILE_EXTENSION = ".xml";
    public static final String FILE_PREFIX = "STATUS_0";

    //Channel Constants
    static final String TIMER_PROCESSING_OUTPUT_CHANNEL = "RouterToTimerMonitorChannel";
    static final String STATUS_PROCESSING_OUTPUT_CHANNEL = "RouterToStatusMonitorChannel";

    //Testing constants
    public static final String RESULTS_FILE_NAME = "MessageResults.csv";
    public static final String RESULTS_FILE_PATH = "..\\MessageReader\\results\\";
    public static final String DELIMETER = ",";
    public static final String START_TIME = "StartMessageProcessingTime";
    public static final String END_TIME = "EndMessageProcessingTime";
    public static final String END_CONVERSION_TIME = "EndConversionTime";


}
