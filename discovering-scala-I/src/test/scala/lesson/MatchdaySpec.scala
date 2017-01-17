package lesson

import org.scalatest.{FeatureSpec, GivenWhenThen}

import scala.collection.immutable.TreeSet

class MatchdaySpec extends FeatureSpec with GivenWhenThen {

  feature("A new Matchday") {

    scenario("A new matchday") {
      Given("A new matchday")
      val newMatchDay = MatchDay(1)

      Then("Number of matches")
      val numberOfMatches = newMatchDay.numberOfMatches
      assert(numberOfMatches == 0)
    }

    scenario("Number of participants") {
      Given("Matchday1")
      val matchday = MatchDay.MatchDay1

      Then("Number of teams")
      val numberOfParticipants = matchday.numberOfTeams
      assert(numberOfParticipants == 6)
    }

    scenario("Number of goals") {
      Given("Matchday1")
      val matchday = MatchDay.MatchDay1

      Then("Number of goals")
      val numberOfGoals = matchday.numberOfGoals
      assert(numberOfGoals == 10)
    }

    scenario("Add matches to a new matchday") {
      Given("A new matchday")
      val newMatchDay = MatchDay(1)

      When("Add 3 matches")
      val updatedMatchday = newMatchDay.addMatches(Match.match1, Match.match2, Match.match3)

      Then("Number of matches - equal to Matchday1")
      assert(updatedMatchday.numberOfMatches == 3)
    }

    scenario("Sorted by Participant name") {
      Given("Two matchdays1")
      val matchday = MatchDay.MatchDay1

      Then("Check the order")
      val participantsSortedByName = matchday.teamsSortedByName
      assert(participantsSortedByName.indexOf(Team.Bayern) == 0)
      assert(participantsSortedByName.indexOf(Team.Dortmund) == 1)
      assert(participantsSortedByName.indexOf(Team.Kaiserslautern) == 2)
      assert(participantsSortedByName.indexOf(Team.Koeln) == 3)
      assert(participantsSortedByName.indexOf(Team.Leverkusen) == 4)
      assert(participantsSortedByName.indexOf(Team.Schalke) == 5)
    }

    scenario("Number of redcards in sections") {
      Given("Two matchdays1")
      val matchday = MatchDay.MatchDay1
      val matchday2 = MatchDay.MatchDay2

      Then("Check number of redcards in section")
      val redcardsInSections = MatchDay.redCardsPerSection(matchday :: matchday2 :: Nil)
      assert(redcardsInSections == (2, 1))
    }

    scenario("Plays on all Matchdays") {
      Given("Two matchdays")
      val matchday = MatchDay.MatchDay1
      val matchday2 = MatchDay.MatchDay2

      Then("Some are present, some not..")
      val playsOnAllMatchdays = MatchDay.playsOnAllMatchdays(matchday :: matchday2 :: Nil)
      assert(playsOnAllMatchdays.contains(Team.Bayern))
      assert(playsOnAllMatchdays.contains(Team.Dortmund))
      assert(playsOnAllMatchdays.contains(Team.Koeln))
      assert(playsOnAllMatchdays.contains(Team.Leverkusen))
      assert(playsOnAllMatchdays.contains(Team.Schalke))
      assert(!playsOnAllMatchdays.contains(Team.Hamburg))
      assert(!playsOnAllMatchdays.contains(Team.Kaiserslautern))
    }

    scenario("Mapped by Participant") {
      Given("Two matchdays")
      val matchday = MatchDay.MatchDay1
      val matchday2 = MatchDay.MatchDay2

      val mappedByParticipant = MatchDay.mappedByParticipant(matchday :: matchday2 :: Nil)

      assert(mappedByParticipant.size == 7)
      assert(mappedByParticipant(Team.Bayern) == TreeSet(matchday, matchday2))
      assert(mappedByParticipant(Team.Dortmund) == TreeSet(matchday, matchday2))
      assert(mappedByParticipant(Team.Koeln) == TreeSet(matchday, matchday2))
      assert(mappedByParticipant(Team.Leverkusen) == TreeSet(matchday, matchday2))
      assert(mappedByParticipant(Team.Schalke) == TreeSet(matchday, matchday2))
      assert(mappedByParticipant(Team.Hamburg) == TreeSet(matchday2))
      assert(mappedByParticipant(Team.Kaiserslautern) == TreeSet(matchday))
    }
  }

}
