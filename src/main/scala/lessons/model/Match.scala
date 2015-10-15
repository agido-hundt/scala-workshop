package lessons.model

case class Redcard(minute: Int)

case class Match(home: Participant, away: Participant, betmarketCount: Int, redcard: Option[Redcard] = None)