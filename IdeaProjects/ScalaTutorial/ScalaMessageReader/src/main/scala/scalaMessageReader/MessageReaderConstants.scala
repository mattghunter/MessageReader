package scalaMessageReader

object MessageReaderConstants {
  val ENTITY_NAME = "EntityName"
  val STATUS = "Status"

  val START_TIME = "StartTime"
  val END_TIME = "EndTime"
  val END_CONVERSION_TIME = "EndConversion"

  val DATE = "Date"
  val TIME = "Time"
  val FILE_PATH = "..\\ScalaTutorial\\ScalaMessageReader\\xmlFiles\\"
  val FULL_FILE_PATH = "C:\\Users\\mattg\\IdeaProjects\\ScalaTutorial\\ScalaMessageReader\\xmlFiles\\"
  val FILE_EXTENSION = ".xml"
  val FILE_PREFIX = "STATUS_0"

//  MESSAGE CHANNELS
  val STATUS_PROCESSING_OUTPUT_CHANNEL = "RouterToStatusMonitorChannel"
  val TIMER_PROCESSING_OUTPUT_CHANNEL = "RouterToTimerMonitorChannel"
  val RESULTS_FILE_NAME = "MessageResults.csv"
  val RESULTS_FILE_PATH = "C:\\Users\\mattg\\IdeaProjects\\ScalaTutorial\\ScalaMessageReader\\results\\"
}
