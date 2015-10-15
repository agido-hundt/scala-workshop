package lessons

import lessons.model.{Redcard, Participant, Match}

import scala.collection.immutable.TreeSet

object Matchday {
  val emptyMatchDay = Matchday(None, Nil)
  val matchday1 = Matchday(Some(1), List[Match](Match.match1, Match.match2, Match.match3))
  val matchday2 = Matchday(Some(2), List[Match](Match.match4, Match.match5, Match.match6))

  def redcardsInSection(matchdays: List[Matchday]): (Int, Int) = ??? // TODO Write body

  def playsOnAllMatchdays(matchdays: List[Matchday]): List[Participant] = ??? // TODO Write body

  def mappedByParticipant(matchdays: List[Matchday]): Map[Participant, TreeSet[Matchday]] = ???
}

case class Matchday(day: Option[Int], matches: List[Match]) extends Comparable[Matchday] {

  def numberOfMatches: Int = ??? // TODO Write body

  def numberOfParticipants: Int = ??? // TODO Write body

  def numberOfBetmarkets: Int = ??? // TODO Write body

  def addMatches(matchesToAdd: Match*): Matchday = ??? // TODO Write body

  def participantsSortedByName: List[Participant] = ??? // TODO Write body

  override def compareTo(o: Matchday): Int = ??? // TODO Write compareTo method based on [[Matchday.day]]
}
