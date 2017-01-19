package election.step3.actor

import akka.actor.{Actor, Props}

import scala.util.Random

class ElectionActor(electionName: String) extends Actor {
  def receive: Receive = {
    case x => println(x)
  }
}

object ElectionActor {
  def randomElectionProps: Props = {
    val randomName = Random.alphanumeric.take(10).mkString
    Props(new ElectionActor(randomName))
  }
}