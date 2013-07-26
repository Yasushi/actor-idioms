package idioms

import scala.concurrent.duration._
import org.scalatest.WordSpec
import org.scalatest.matchers.MustMatchers
import akka.actor.{ActorSystem, Props}
import akka.testkit.{TestActorRef, TestKit}

class LabelSpec extends TestKit(ActorSystem()) with WordSpec with MustMatchers with StopSystemAfterAll {

  "A Label Actor" must {
    "reply labeled message" in {
      val label = system.actorOf(Props(new Label(testActor, "label")))
      label ! "msg"
      expectMsgPF() {
        case (label, msg) =>
          label must be("label")
          msg must be("msg")
      }
    }
  }

}
