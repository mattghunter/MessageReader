package scalaMessageReader.endpoint

import org.springframework.messaging.Message

import scalaMessageReader.Notification

trait MessageEndpoint {

  def handleMessage(message : Message[Notification]) : Unit

}
