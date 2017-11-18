package actors.chat

import akka.actor.Actor


class ChatServerActor extends Actor {

  override def preStart: Unit = println("starting chat server")
  override def postStop: Unit = println("stopping chat server")

  override def receive: Receive = {
    case "test" => 
      println("client received test message")
  }

}
