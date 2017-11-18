import sbt._
 
class ChatProject(info: ProjectInfo) extends DefaultProject(info) with AkkaProject {
  val akkaRepo = "Akka Repo" at "http://repo.akka.io/releases"
  val akkaSTM    = akkaModule("stm")
  val akkaRemote = akkaModule("remote")
}
