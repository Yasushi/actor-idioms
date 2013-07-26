package idioms

import akka.actor.{Actor, ActorRef}

class Forward(subject: ActorRef) extends Actor {
  def receive = {
    case msg => subject ! msg
  }
}
