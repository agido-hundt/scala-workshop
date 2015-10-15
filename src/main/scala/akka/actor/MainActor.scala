package akka.actor

/**
 * Main Actor which starts the handshake
 */
class MainActor extends Actor with ActorLogging{

  override def preStart(): Unit = {
   //Create a Greeter actor log something and send greeting
  }
  override def receive: Receive ={
    // react on done message log something and stop
    ???
  }
}
