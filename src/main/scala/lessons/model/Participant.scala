package lessons.model

case class Participant(name: String) extends Comparable[Participant] {
  override def compareTo(o: Participant): Int = ??? // TODO Write compareTo methode  based on [[Participant.name]]
}