package scalaMessageReader

import java.io.File

import org.junit.Test
import org.junit.Before
import org.springframework.messaging.support.GenericMessage

import scala.collection.mutable

class FileToMapConverterTest {

  var newMessage : GenericMessage[File] = _
  var xmlFile : File = _
  var result : mutable.Map[String,String] = _
  var unit : FileToMapConverter = _

  @Before def initialize(): Unit = {
    unit = new FileToMapConverter
  }

  @Test def test_convert(): Unit = {
    xmlFile = new File("C:\\Users\\mattg\\IdeaProjects\\ScalaTutorial\\scalaMessageReader\\src\\test\\resources\\scalaMessageReader\\validTEST_STATUS_00.xml")
    newMessage = new GenericMessage[File](xmlFile)
    result = unit.convert(newMessage)

    assert(Option("STATUS_00").equals(result.get(MessageReaderConstants.ENTITY_NAME)))
    assert(Option("1").equals(result.get(MessageReaderConstants.STATUS)))
    assert(result.contains(MessageReaderConstants.START_TIME))
    assert(result.size == 3)
  }

}
