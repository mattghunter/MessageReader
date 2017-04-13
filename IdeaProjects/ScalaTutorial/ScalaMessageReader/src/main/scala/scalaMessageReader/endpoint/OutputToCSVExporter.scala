package scalaMessageReader.endpoint
import java.io.{BufferedWriter, FileWriter}

import org.springframework.messaging.Message

import scala.collection.mutable
import scalaMessageReader.Notification
import scalaMessageReader.MessageReaderConstants._

class OutputToCSVExporter extends MessageEndpoint {

  final val DELIMETER = ","

  override def handleMessage(message: Message[Notification]) : Unit = {
    val messageMap : mutable.Map[String,String] = message.getPayload.messageDetails
    messageMap.put(END_TIME, message.getPayload.endProcessingTime)
    if (messageMap.contains(START_TIME)) exportToCSV(messageMap)
  }

  def exportToCSV(message : mutable.Map[String,String]) : Unit = {
    val fileWriter = new FileWriter(RESULTS_FILE_PATH + RESULTS_FILE_NAME, true)
    val bw = new BufferedWriter(fileWriter)
    bw.append(message(ENTITY_NAME)).append(DELIMETER)
          .append(message(START_TIME)).append(DELIMETER)
          .append(message(END_CONVERSION_TIME)).append(DELIMETER)
          .append(message(END_TIME)).append(DELIMETER)
          .append(message(STATUS))
    bw.newLine()
    bw.close()
    fileWriter.close()
  }
}
