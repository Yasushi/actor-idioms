package idioms

import scala.concurrent.duration._
import org.scalatest.WordSpec
import org.scalatest.matchers.MustMatchers
import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.testkit.{TestActorRef, TestKit}

class Echo extends Actor {
  def receive = {
    case (cust: ActorRef, req) => cust ! (self, req)
  }
}

class RaceSpec extends TestKit(ActorSystem()) with WordSpec with MustMatchers with StopSystemAfterAll {

  "A Race Actor" must {
    "receive first" in {
      val a1 = system.actorOf(Props[Echo])
      val a2 = system.actorOf(Props[Echo])
      val a3 = system.actorOf(Props[Echo])
      val list = Seq(a1, a2, a3)
      val race = system.actorOf(Props(classOf[Race], list))
      race ! (testActor, "msg")
      expectMsgPF() {
        case (actor: ActorRef, msg) =>
          list must contain(actor)
          msg must be("msg")
      }
      expectNoMsg()
    }
  }
}

