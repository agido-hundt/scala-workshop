package lesson

import scala.collection.immutable.TreeSet

case class MatchDay(day: Int, matches: List[Match]) extends Comparable[MatchDay] {

  def numberOfMatches: Int = ??? // TODO Write body

  def numberOfTeams: Int = ??? // TODO Write body

  def numberOfGoals: Int = ??? // TODO Write body

  def addMatches(matchesToAdd: Match*): MatchDay = ??? // TODO Write body

  def teamsSortedByName: List[Team] = ??? // TODO Write body

  override def compareTo(o: MatchDay): Int = ??? // TODO Write compareTo method based on [[Matchday.day]]

}

object MatchDay {

  def apply(day: Int): MatchDay = MatchDay(day, List.empty)

  val MatchDay1: MatchDay = MatchDay(1, List[Match](Match.match1, Match.match2, Match.match3))

  val MatchDay2: MatchDay = MatchDay(2, List[Match](Match.match4, Match.match5, Match.match6))

  /**
    * Returns the number of red cards per section, assuming a football halftime has a fixed duration of 45 minutes
    */
  def redCardsPerSection(matchdays: List[MatchDay]): (Int, Int) = ??? // TODO Write body

  /**
    * Return a set of those teams which play on all given match days
    */
  def playsOnAllMatchdays(matchdays: List[MatchDay]): Set[Team] = ??? // TODO Write body

  /**
    * Returns a map,
    */
  def mappedByParticipant(matchdays: List[MatchDay]): Map[Team, TreeSet[MatchDay]] = ??? // TODO Write body

}