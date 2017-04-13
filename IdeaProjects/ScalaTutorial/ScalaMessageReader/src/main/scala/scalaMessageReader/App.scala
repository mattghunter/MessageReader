package scalaMessageReader

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@SpringBootApplication
object App  {

  def main (args: Array[String]) : Unit = {
    val applicationContext = new ClassPathXmlApplicationContext("application-context.xml")
    val logger : Logger = LoggerFactory.getLogger(classOf[App])
    logger.info("Starting the Application Main")
    SpringApplication.run(classOf[App])
  }
}
