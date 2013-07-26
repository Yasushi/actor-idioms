package idioms

import scala.concurrent.duration._
import org.scalatest.WordSpec
import org.scalatest.matchers.MustMatchers
import akka.actor.{ActorSystem, Props}
import akka.testkit.{TestActorRef, TestKit}

class TagSpec extends TestKit(ActorSystem()) with WordSpec with MustMatchers with StopSystemAfterAll {

  "A Tag Actor" must {
    "reply tagged message" in {
      val tag = system.actorOf(Props(classOf[Tag], testActor))
      tag ! "msg"
      expectMsgPF() {
        case (tag, msg) =>
          tag must be(tag)
          msg must be("msg")
      }
    }
  }

}
