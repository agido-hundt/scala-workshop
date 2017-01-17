package election.step1.actor

import akka.actor.{Actor, Props}

import scala.util.Random

class ElectionActor(electionName: String) extends Actor {
  def receive: Receive = Actor.emptyBehavior
}

object ElectionActor {
  def randomElectionProps: Props = {
    val randomName = Random.alphanumeric.take(10).mkString
    Props(new ElectionActor(randomName))
  }
}