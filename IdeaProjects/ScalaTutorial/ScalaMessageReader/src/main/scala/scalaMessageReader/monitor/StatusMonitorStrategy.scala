package scalaMessageReader.monitor

import scala.collection.mutable
import scalaMessageReader.MessageReaderConstants.STATUS

class StatusMonitorStrategy {

  def isInError (message : mutable.Map[String,String]) : Boolean = {
    message(STATUS).equals("2")
  }

}
