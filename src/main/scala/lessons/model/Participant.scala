package lessons.model

object Participant {
  val bayern = Participant("Bayern")
  val dortmund = Participant("Dortmund")
  val hamburg = Participant("Hamburg")
  val kaiserslautern = Participant("Kaiserslautern")
  val koeln = Participant("Köln")
  val leverkusen = Participant("Leverkusen")
  val schalke = Participant("Schalke")
}

case class Participant(name: String) extends Comparable[Participant] {
  override def compareTo(o: Participant): Int = ??? // TODO Write compareTo methode  based on [[Participant.name]]
}