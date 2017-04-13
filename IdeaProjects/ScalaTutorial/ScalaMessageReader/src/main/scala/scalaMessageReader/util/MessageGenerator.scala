package scalaMessageReader.util

import java.io.{File, FileWriter}

import org.jdom2.output.{Format, XMLOutputter}
import org.jdom2.{Document, Element}
import org.slf4j.{Logger, LoggerFactory}

import scalaMessageReader.MessageReaderConstants


object MessageGenerator {

  val MESSAGE_VOLUME = 100000
  val logger : Logger = LoggerFactory.getLogger("MessageGenerator")

  def main(args: Array[String]): Unit = {
    clearDirectory()
    var i = 0
    while (i < MESSAGE_VOLUME) {
      {
        generateXml(i, logger)
      }
      {
        i += 1;
        i - 1
      }
    }
  }

  private def clearDirectory() {
    logger.info("Gathering Files")
    val directory = new File(MessageReaderConstants.FILE_PATH).listFiles()
    if (directory != null) {
      logger.info("Clearing Directory")
      for (file <- directory) if (!file.isDirectory) file.delete()
    }
  }

  def createNewDocument(messageNumber: Int) = {
    val root = new Element("StatusMessage")
    val doc = new Document
    val entityName = new Element("EntityName")
    entityName.addContent(MessageReaderConstants.FILE_PREFIX + Integer.toString(messageNumber))
    val status = new Element("Status")
    status.addContent(Integer.toString(if (Math.random <= 0.5) 1
    else 2))
    root.addContent(entityName)
    root.addContent(status)
    doc.setRootElement(root)
    doc  }

  def generateXml(i: Int, logger: Logger) {
    val doc = createNewDocument(i)
    val outputter = new XMLOutputter
    outputter.setFormat(Format.getPrettyFormat)
    val filename = MessageReaderConstants.FILE_PREFIX + i + MessageReaderConstants.FILE_EXTENSION
    val file : File = new File(filename)

    outputter.output(doc, new FileWriter(MessageReaderConstants.FILE_PATH + file))
    logger.info("File Created with name: " + filename)
  }
}
