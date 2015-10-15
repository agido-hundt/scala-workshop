package lessons

import lessons.model.{Redcard, Participant, Match}

import scala.collection.immutable.TreeSet

object Matchday {

  val bayern = Participant("Bayern")
  val dortmund = Participant("Dortmund")
  val hamburg = Participant("Hamburg")
  val kaiserslautern = Participant("Kaiserslautern")
  val koeln = Participant("Köln")
  val leverkusen = Participant("Leverkusen")
  val schalke = Participant("Schalke")

  // 90
  val match1 = Match(bayern, dortmund, 30)
  val match2 = Match(kaiserslautern, koeln, 20, Some(Redcard(50)))
  val match3 = Match(leverkusen, schalke, 40, Some(Redcard(10)))

  // 100
  val match4 = Match(bayern, schalke, 10)
  val match5 = Match(hamburg, leverkusen, 40)
  val match6 = Match(koeln, dortmund, 50, Some(Redcard(44)))

  val emptyMatchDay = Matchday(None, Nil)
  val matchday1 = Matchday(Some(1), List[Match](match1, match2, match3))
  val matchday2 = Matchday(Some(2), List[Match](match4, match5, match6))

  def redcardsInSection(matchdays: List[Matchday]): (Int, Int) = ??? // TODO Write body

  def playsOnAllMatchdays(matchdays: List[Matchday]): List[Participant] = ??? // TODO Write body

  def mappedByParticipant(matchdays: List[Matchday]): Map[Participant, TreeSet[Matchday]] = ???
}

case class Matchday(day: Option[Int], matches: List[Match]) extends Comparable[Matchday] {

  def numberOfMatches: Int = ??? // TODO Write body

  def numberOfParticipants: Int = ??? // TODO Write body

  def numberOfBetmarkets: Int = ??? // TODO Write body

  def addMatches(matchesToAdd: Match*): Matchday = ??? // TODO Write body

  def participantsSortedByName: TreeSet[Participant] = ??? // TODO Write body

  override def compareTo(o: Matchday): Int = ??? // TODO Write compareTo method based on [[Matchday.day]]
}
