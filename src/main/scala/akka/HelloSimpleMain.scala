package akka

import akka.actor._

/**
 * Simple main class for starting actors
 */
object HelloSimpleMain {

  def main(args: Array[String]): Unit = {
    greeter()
//    philosopher()
  }

  def greeter() = {
    val system = ActorSystem("Greeter")
    system.actorOf(Props[MainActor], name="main")
  }



  def philosopher() = {

  }


}
