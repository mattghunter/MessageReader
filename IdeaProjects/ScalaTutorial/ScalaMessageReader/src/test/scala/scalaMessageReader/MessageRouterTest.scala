package scalaMessageReader

import org.junit.Test
import org.junit.Before
import org.scalatest.junit.AssertionsForJUnit

import scala.collection.mutable

class MessageRouterTest {

  var unit : MessageRouter = new MessageRouter

  @Before def initialize(): Unit = {
    unit = new MessageRouter
  }

  @Test def test_routeStatusMessage(): Unit = {
    val map : mutable.Map[String, String] = mutable.Map(MessageReaderConstants.ENTITY_NAME -> "TestEntity",
                                                          MessageReaderConstants.STATUS -> "1")

    val result : java.util.List[String] = unit.route(map)

    assert(result.size == 1)
    assert(result.contains("String"))
  }
}
