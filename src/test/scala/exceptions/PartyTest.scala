import character.specializations.BlackMage
import character.specializations.WhiteMage
import character.specializations.Paladin
import character.specializations.Ninja
import character.specializations.Warrior
import party.Party
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

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
    ninja = new Ninja("Naruto", 20, 15, 70)
    warrior = new Warrior("Pepsita", 35, 8, 62)
    party = new Party()

  }

  test("Testing addCharacter method") {
    party.addCharacter(paladin)
    party.addCharacter(whiteMage)

    assertEquals(party.currentParty(0), paladin)
    assertEquals(party.currentParty(1), whiteMage)
  }

  test("Testing isDefeated method"){
    party.addCharacter(paladin)
    party.addCharacter(whiteMage)

    assertEquals(party.isDefeated, false)
  }
}
