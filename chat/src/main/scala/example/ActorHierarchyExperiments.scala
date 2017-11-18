/**
 * Example from https://doc.akka.io/docs/akka/current/scala/guide/tutorial_1.html
 */
 
import akka.actor.{Actor, Props, ActorSystem }
import scala.io.StdIn


class PrintMyActorRefActor extends Actor {

  override def receive: Receive = {
    case "printit" =>
      val secondRef = context.actorOf(Props.empty, "second-actor")
      println(s"Second: $secondRef")
  }

}


object ActorHierarchyExperiments extends App {
  val system = ActorSystem("testSystem")

  val firstRef = system.actorOf(Props[PrintMyActorRefActor], "first-actor")
  println(s"First: $firstRef")
  firstRef ! "printit"

  println(">>> press enter to exit >>>")

  try StdIn.readLine()
  finally system.terminate()

}
