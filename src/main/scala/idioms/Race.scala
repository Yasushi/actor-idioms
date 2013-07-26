package idioms

import akka.actor.{Actor, ActorRef, Props}

class Race(list: Seq[ActorRef]) extends Actor {
  def receive = {
    case (cust, req) =>
      val oneShot = context.actorOf(Props(classOf[OneShot], cust))
      sendToAll((oneShot, req), list)
  }

  def sendToAll(msg: (ActorRef, Any), list: Seq[ActorRef]) = list.foreach(_ ! msg)

}
