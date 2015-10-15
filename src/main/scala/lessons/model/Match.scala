package lessons.model

case class Redcard(minute: Int)

object Match {
  // 90
  val match1 = Match(Participant.bayern, Participant.dortmund, 30)
  val match2 = Match(Participant.kaiserslautern, Participant.koeln, 20, Some(Redcard(50)))
  val match3 = Match(Participant.leverkusen, Participant.schalke, 40, Some(Redcard(10)))

  // 100
  val match4 = Match(Participant.bayern, Participant.schalke, 10)
  val match5 = Match(Participant.hamburg, Participant.leverkusen, 40)
  val match6 = Match(Participant.koeln, Participant.dortmund, 50, Some(Redcard(44)))
}

case class Match(home: Participant, away: Participant, betmarketCount: Int, redcard: Option[Redcard] = None)