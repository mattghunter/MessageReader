package scalaMessageReader.performanceTest

import org.junit.{Before, Test}
import org.junit.runner.RunWith
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.{Autowired, Qualifier}
import org.springframework.integration.channel.DirectChannel
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import sun.plugin2.message.Message

import scalaMessageReader.MessageReaderConstants
import scalaMessageReader.util.MessageSender

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(locations = Array("classpath:/application-context.xml"))
class PerformanceTest {

  @Autowired @Qualifier("InputToConverterChannel") var converterInputChannel : DirectChannel = _

  val logger : Logger = LoggerFactory.getLogger(classOf[PerformanceTest])
  val messageSender : MessageSender = new MessageSender

  @Test def test_PerformanceScalaComponents(): Unit = {
    messageSender.sendMessages(converterInputChannel, MessageReaderConstants.FILE_PATH)
  }
}
