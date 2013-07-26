package idioms

import scala.concurrent.duration._
import org.scalatest.WordSpec
import org.scalatest.matchers.MustMatchers
import akka.actor.{ActorSystem, Props}
import akka.testkit.{TestActorRef, TestKit}

class SinkSpec extends TestKit(ActorSystem()) with WordSpec with MustMatchers with StopSystemAfterAll {

  "A Sinker Actor" must {
    "no response" in {
      val sink = system.actorOf(Props[Sink])
      sink ! "whisper"
      expectNoMsg()
    }
  }
}

