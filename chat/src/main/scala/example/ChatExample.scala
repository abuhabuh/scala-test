package example

import akka.actor.{Actor, Props, ActorSystem }
import scala.io.StdIn

import actors.chat.ChatClientActor
import actors.chat.ChatServerActor


object ChatExample extends App {
  val system = ActorSystem("ChatExampleSystem")

  val clientActorRef = system.actorOf(Props[ChatClientActor], "clientActor")
  val serverActorRef = system.actorOf(Props[ChatServerActor], "serverActor")

  println("Starting chat app")

  try StdIn.readLine("Press anykey to exit: ")
  finally system.terminate()
}
