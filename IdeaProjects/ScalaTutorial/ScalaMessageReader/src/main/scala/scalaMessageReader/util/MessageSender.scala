package scalaMessageReader.util

import java.io.File

import org.springframework.messaging.MessageChannel
import org.springframework.messaging.support.GenericMessage

import scalaMessageReader.MessageReaderConstants

class MessageSender {

  def sendMessages(messageChannel : MessageChannel, filePath : String): Unit = {
    val directory = new File(MessageReaderConstants.FULL_FILE_PATH).listFiles()
    assert(directory != null)
    for (file <- directory) messageChannel.send(new GenericMessage[File](file))
  }
}
