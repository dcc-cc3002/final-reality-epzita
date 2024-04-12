package exceptions.partyExceptions

import character.specializations._
import munit.FunSuite
import party.Party


class PartyTest extends FunSuite {
  var party: Party = _
  var blackMage: BlackMage = _
  var whiteMage: WhiteMage = _
  var paladin: Paladin = _
  var ninja: Ninja = _
  var warrior: Warrior = _


  override def beforeEach(context: BeforeEach): Unit = {
    blackMage = new BlackMage("Saruman", 20, 10, 50, 95)
    whiteMage = new WhiteMage("Gandalf", 15, 5, 60, 100)
    paladin = new Paladin("Belfor", 30, 10, 75)
    ninja = new Ninja("Naruto", 0, 15, 70)
    warrior = new Warrior("Pepsita", 0, 8, 62)
    party = new Party()

  }

  test("Testing addMember method") {
    party.addMember(paladin)
    party.addMember(whiteMage)

    assertEquals(party.currentParty(0), paladin)
    assertEquals(party.currentParty(1), whiteMage)
  }

  test("Testing isDefeated method when false"){
    party.addMember(paladin)
    party.addMember(whiteMage)

    assertEquals(party.isDefeated, false)
  }

  test("Testing isDefeated method when true"){
    party.addMember(ninja)
    party.addMember(warrior)

    assertEquals(party.isDefeated, true)
  }
}
