package scalaMessageReader

import scalaMessageReader.MessageReaderConstants.{STATUS_PROCESSING_OUTPUT_CHANNEL,TIMER_PROCESSING_OUTPUT_CHANNEL}

import org.springframework.integration.annotation.Router

import scala.collection.mutable

class MessageRouter {

  @Router def route (payload : mutable.Map[String,String]) : java.util.List[String] = {
    val routingChannels: java.util.List[String] = new java.util.ArrayList[String]()

    if(payload.contains(MessageReaderConstants.STATUS)) routingChannels.add(STATUS_PROCESSING_OUTPUT_CHANNEL)

    if(payload.contains(MessageReaderConstants.DATE) && payload.contains(MessageReaderConstants.TIME))
      routingChannels.add(TIMER_PROCESSING_OUTPUT_CHANNEL)

    routingChannels
  }

}
