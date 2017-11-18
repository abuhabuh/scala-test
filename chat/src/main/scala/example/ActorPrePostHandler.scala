/**
 * Example from https://doc.akka.io/docs/akka/current/scala/guide/tutorial_1.html
 */

import akka.actor.{Actor, Props, ActorSystem }
import scala.io.StdIn


class StartStopActor1 extends Actor {
  override def preStart(): Unit = {
    println("first started")
    context.actorOf(Props[StartStopActor2], "second")
  }
  override def postStop(): Unit = println("first stopped")

  override def receive: Receive = {
    case "stop" => context.stop(self)
  }
}


class StartStopActor2 extends Actor {
  override def preStart(): Unit = println("second started")
  override def postStop(): Unit = {
    println(self)
    println("second stopped")
  }

  override def receive: Receive = Actor.emptyBehavior
}


object ActorPrePostHandler extends App {
  val system = ActorSystem("testSystem")

  val first = system.actorOf(Props[StartStopActor1], "first-actor")
  first ! "stop"
  system.terminate()
}


