package lessons

import lessons.model.{Redcard, Match, Participant}
import org.scalatest.{GivenWhenThen, FeatureSpec}

import scala.collection.immutable.TreeSet

class MatchdaySpec extends FeatureSpec with GivenWhenThen {

  feature("A new Matchday") {

    scenario("A new matchday") {
      Given("A new matchday")
      val matchday = Matchday.emptyMatchDay

      Then("Number of matches")
      val numberOfMatches = matchday.numberOfMatches
      assert(numberOfMatches == 0)
    }

    scenario("Number of participants") {
      Given("Matchday1")
      val matchday = Matchday.matchday1

      Then("Number of participants")
      val numberOfParticipants = matchday.numberOfParticipants
      assert(numberOfParticipants == 6)
    }

    scenario("Number of betmarkets") {
      Given("Matchday1")
      val matchday = Matchday.matchday1

      Then("Number of betmarkets")
      val numberOfBetmarkets = matchday.numberOfBetmarkets
      assert(numberOfBetmarkets == 90)
    }

    scenario("Add matches to a new matchday") {
      Given("A new matchday")
      val matchday = Matchday.emptyMatchDay

      When("Add 3 matches")
      val updatedMatchday = matchday.addMatches(Match.match1, Match.match2, Match.match3)

      Then("Number of matches - equal to Matchday1")
      assert(updatedMatchday.numberOfMatches == 3)
    }

    scenario("Sorted by Participant name") {
      Given("Two matchdays1")
      val matchday = Matchday.matchday1

      Then("Check the order")
      val participantsSortedByName = matchday.participantsSortedByName
      assert(participantsSortedByName.indexOf(Participant.bayern) == 0)
      assert(participantsSortedByName.indexOf(Participant.dortmund) == 1)
      assert(participantsSortedByName.indexOf(Participant.kaiserslautern) == 2)
      assert(participantsSortedByName.indexOf(Participant.koeln) == 3)
      assert(participantsSortedByName.indexOf(Participant.leverkusen) == 4)
      assert(participantsSortedByName.indexOf(Participant.schalke) == 5)
    }

    scenario("Number of redcards in sections") {
      Given("Two matchdays1")
      val matchday = Matchday.matchday1
      val matchday2 = Matchday.matchday2

      Then("Number of betmarkets")
      val redcardsInSections = Matchday.redcardsInSection(matchday :: matchday2 :: Nil)
      assert(redcardsInSections == (2,1))
    }

    scenario("Plays on all Matchdays") {
      Given("Two matchdays")
      val matchday = Matchday.matchday1
      val matchday2 = Matchday.matchday2

      Then("Some are present, some not..")
      val playsOnAllMatchdays = Matchday.playsOnAllMatchdays(matchday :: matchday2 :: Nil)
      assert(playsOnAllMatchdays.contains(Participant.bayern))
      assert(playsOnAllMatchdays.contains(Participant.dortmund))
      assert(playsOnAllMatchdays.contains(Participant.koeln))
      assert(playsOnAllMatchdays.contains(Participant.leverkusen))
      assert(playsOnAllMatchdays.contains(Participant.schalke))
      assert(!playsOnAllMatchdays.contains(Participant.hamburg))
      assert(!playsOnAllMatchdays.contains(Participant.kaiserslautern))
    }
  }

}
