package lesson


import scala.collection.immutable.Seq


case class MatchDay(day: Int, matches: List[Match]) extends Comparable[MatchDay] {

  private def teams: Set[Team] = matches.flatMap(_.teams).toSet

  def numberOfMatches: Int = matches.size

  def numberOfTeams: Int = teams.size

  def numberOfGoals: Int = matches.map(_.goals).sum

  def addMatches(matchesToAdd: Match*): MatchDay = {
    copy(matches = matchesToAdd.toList ::: matches)
  }

  def teamsSortedByName: List[Team] = teams.toList.sortWith(_.name < _.name)

  def compareTo(o: MatchDay): Int = day.compare(o.day)

}

object MatchDay {

  def apply(day: Int): MatchDay = MatchDay(day, List.empty)

  val MatchDay1: MatchDay = MatchDay(1, List[Match](Match.match1, Match.match2, Match.match3))

  val MatchDay2: MatchDay = MatchDay(2, List[Match](Match.match4, Match.match5, Match.match6))

  /**
    * Returns the number of red cards per section, assuming a football halftime has a fixed duration of 45 minutes
    */
  def redCardsPerSection(matchdays: List[MatchDay]): (Int, Int) = {
    val allRedCards: Seq[RedCard] = matchdays.flatMap(_.matches).flatMap(_.redCard)
    val groupedBySection: Map[Boolean, Seq[RedCard]] = allRedCards.groupBy(_.minute > 45)
    val counts: Iterable[Int] = groupedBySection.values.map(_.size)
    val Seq(h1, h2) = counts.toSeq

    (h1, h2)
  }

  /**
    * Return a set of those teams which play on all given match days
    */
  def playsOnAllMatchdays(matchdays: List[MatchDay]): Set[Team] = matchdays.map(_.teams).reduce(_ intersect _)

  /**
    * Returns a map,
    */
  def mappedByParticipant(matchdays: List[MatchDay]): Map[Team, Set[MatchDay]] = {
    matchdays.flatMap(m => m.teams.map(p => (p, m)))
      .groupBy(_._1)
      .mapValues(_.map(_._2).toSet)
  }

}