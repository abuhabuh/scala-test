package actors.chat

import akka.actor.Actor


class ChatClientActor extends Actor {

  override def preStart: Unit = println("starting chat client")
  override def postStop: Unit = println("stopping chat client")

  override def receive: Receive = {
    case "test" => 
      println("client received test message")
  }

}
