package idioms

import akka.actor.{Actor, ActorRef}

class Label[T](cust: ActorRef, label: T) extends Actor {
  def receive = {
    case msg => cust ! (label, msg)
  }
}
