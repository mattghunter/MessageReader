package scalaMessageReader.monitor

import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired

import scala.collection.mutable
import scalaMessageReader.{Notification, NotificationPublisher}
import scalaMessageReader.MessageReaderConstants.{ENTITY_NAME,STATUS}

class StatusMessageMonitor {

  @Autowired val monitorStrategy : StatusMonitorStrategy = null
  @Autowired val notificationPublisher : NotificationPublisher = null

  val logger : Logger = LoggerFactory.getLogger(classOf[StatusMessageMonitor])

  def monitor (message : mutable.Map[String,String]): Unit = {
    logger.debug(message(ENTITY_NAME) + " being monitored in the Status Monitor")

    if (message.contains(STATUS) && monitorStrategy.isInError(message)) {
      logger.info("-- CREATING NOTIFICATION: " + message(ENTITY_NAME) + " -- ERROR --")
      notificationPublisher.publish(new Notification(message))
    } else if (message.contains(STATUS) && !monitorStrategy.isInError(message)) {
      logger.info("-- CREATING NOTIFICATION: " + message(ENTITY_NAME) + " -- ACTIVE --")
      notificationPublisher.publishResolve(new Notification(message))
    } else logger.info("--- Invalid Message Type Hit Monitor ---")
  }

}
