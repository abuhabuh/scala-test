/**
 * Example from https://doc.akka.io/docs/akka/current/scala/guide/tutorial_1.html
 */

import akka.actor.{Actor, Props, ActorSystem }
import scala.io.StdIn


class SupervisingActor extends Actor {
  val child = context.actorOf(Props[SupervisedActor], "child-actor")

  override def receive: Receive = {
    case "failChild" => child ! "fail"
  }

}


class SupervisedActor extends Actor {
  override def preStart: Unit = println("pre start SupervisedActor")
  override def postStop: Unit = println("post stop SupervisedActor")

  override def receive: Receive = {
    case "fail" =>
      println("supervisedActor fails now")
      throw new Exception("i failed")
  }
}


object ActorParentHandler extends App {
  val system = ActorSystem("test-system")

  val parentActor = system.actorOf(Props[SupervisingActor], "parentActor")
  parentActor ! "failChild"


  try StdIn.readLine()
  finally system.terminate()
}