package scalaMessageReader

import org.springframework.messaging.support.GenericMessage
import java.io.File
import java.util.Objects

import scala.collection.mutable
import scala.xml.XML
import scalaMessageReader.MessageReaderConstants.{ENTITY_NAME, START_TIME, STATUS, END_CONVERSION_TIME}

class FileToMapConverter {

  val expectedEntries : List[String] = ENTITY_NAME :: STATUS :: Nil

  def convert (message : GenericMessage[File]) : mutable.Map[String, String] = {
    val xml = XML.loadFile(message.getPayload)
    var map : mutable.Map[String, String] = new mutable.HashMap[String,String]()
    map.put(START_TIME, Objects.toString(System.nanoTime()))

    for (entry <- expectedEntries) {
      map.put(entry, (xml \\ entry).text)
    }

    map.put(END_CONVERSION_TIME, Objects.toString(System.nanoTime()))

    map
  }
}
