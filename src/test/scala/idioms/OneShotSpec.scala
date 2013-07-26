package idioms

import scala.concurrent.duration._
import org.scalatest.WordSpec
import org.scalatest.matchers.MustMatchers
import akka.actor.{ActorSystem, Props}
import akka.testkit.{TestActorRef, TestKit}

class OneShotSpec extends TestKit(ActorSystem()) with WordSpec with MustMatchers with StopSystemAfterAll {

  "A OneShot Actor" must {
    "reply one" in {
      val oneshot = system.actorOf(Props(classOf[OneShot], testActor))
      oneshot ! "one"
      oneshot ! "two"
      oneshot ! "three"
      expectMsg("one")
      expectNoMsg()
    }
  }
}

