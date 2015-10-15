package lessons

import lessons.model.{Redcard, Match, Participant}
import org.scalatest.{GivenWhenThen, FeatureSpec}

class MatchdaySpec extends FeatureSpec with GivenWhenThen {

  feature("A new Matchday") {

    scenario("A new matchday") {
      Given("A new matchday")
      val matchday = Matchday.emptyMatchDay

      Then("Number of matches")
      val numberOfMatches = matchday.numberOfMatches
      assert(numberOfMatches == 0)
    }

    scenario("Add matches to a new matchday") {
      Given("A new matchday")
      val matchday = Matchday.emptyMatchDay

      When("Add 5 matches")
      val updatedMatchday = matchday.addMatches(Matchday.match1, Matchday.match2, Matchday.match3)

      Then("Number of matches - equal to Matchday1")
      assert(updatedMatchday.numberOfMatches == 3)
      assert(updatedMatchday == Matchday.matchday1)
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
      assert(playsOnAllMatchdays.contains(Matchday.bayern))
      assert(playsOnAllMatchdays.contains(Matchday.dortmund))
      assert(playsOnAllMatchdays.contains(Matchday.koeln))
      assert(playsOnAllMatchdays.contains(Matchday.leverkusen))
      assert(playsOnAllMatchdays.contains(Matchday.schalke))
      assert(!playsOnAllMatchdays.contains(Matchday.hamburg))
      assert(!playsOnAllMatchdays.contains(Matchday.kaiserslautern))
    }

    scenario("Group by Participant") {
      Given("Two matchdays")
      Given("Two matchdays")
      val matchday = Matchday.matchday1
      val matchday2 = Matchday.matchday2

      val groupedByParticipant

      Then()
    }

    scenario("Sorted by Participant name") {
      Given("Two matchdays1")
      val matchday = Matchday.matchday1

      Then("Check the order")
      val participantsSortedByName = matchday.participantsSortedByName
      // TODO Write assertions
    }


  }

}
