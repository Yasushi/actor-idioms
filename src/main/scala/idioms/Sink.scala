package idioms

import akka.actor.Actor

class Sink extends Actor {
  def receive = {
    case msg => ()
  }
}
