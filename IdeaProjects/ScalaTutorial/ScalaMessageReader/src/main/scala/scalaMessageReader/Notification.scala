package scalaMessageReader

import java.util.Date

import scala.collection.mutable


class Notification (message : mutable.Map[String,String]) {

  var timeStamp : Date = new Date()
  var messageDetails: mutable.Map[String, String] = message
  var isActive : Boolean = _
  var endProcessingTime : String = _

}
