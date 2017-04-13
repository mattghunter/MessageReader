package scalaMessageReader

import org.springframework.beans.factory.annotation.{Autowired, Qualifier}
import org.springframework.integration.channel.DirectChannel
import org.springframework.messaging.support.GenericMessage


class NotificationPublisher (){

  @Autowired @Qualifier("PublisherToOutputChannel") var outgoingChannel : DirectChannel = _

  var genericMessage : GenericMessage[Notification] = _

  def publish (notification : Notification) : Boolean = {
    sendMessage(notification, active = true)
  }

  def publishResolve (notification: Notification) : Boolean = {
    sendMessage(notification, active = false)
  }

  def sendMessage (notification: Notification, active : Boolean) : Boolean = {
    notification.isActive = active
    notification.endProcessingTime = System.nanoTime().toString
    genericMessage = new GenericMessage[Notification](notification)
    outgoingChannel.send(genericMessage)
  }
}
