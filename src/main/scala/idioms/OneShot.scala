package idioms

import akka.actor.{Actor, ActorRef}

class OneShot(cust: ActorRef) extends Actor {
  def receive = {
    case msg =>
      cust ! msg
      context.become(sink)
  }

  def sink: Receive = {
    case msg => ()
  }
}
