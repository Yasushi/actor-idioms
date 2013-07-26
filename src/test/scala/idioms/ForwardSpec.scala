package idioms

import scala.concurrent.duration._
import org.scalatest.WordSpec
import org.scalatest.matchers.MustMatchers
import akka.actor.{ActorSystem, Props}
import akka.testkit.{TestActorRef, TestKit}

class ForwardSpec extends TestKit(ActorSystem()) with WordSpec with MustMatchers with StopSystemAfterAll {

  "A Forward Actor" must {
    "forward to subject" in {
      val forward = system.actorOf(Props(classOf[Forward], testActor))
      forward ! "msg"
      expectMsg("msg")
    }
  }
}
