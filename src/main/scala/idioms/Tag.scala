package idioms

import akka.actor.{Actor, ActorRef}

class Tag(cust: ActorRef) extends Actor {
  def receive = {
    case msg => cust ! (self, msg)
  }
}
