package model.characterTest

import model.character.specializations.BlackMage
import munit.FunSuite

class BlackMageTest extends FunSuite{
  var blackMage: BlackMage = _


  override def beforeEach(context: BeforeEach): Unit ={
    blackMage = new BlackMage("Saruman", 20, 10, 50, 95)
  }
  test("Checking correct asignment of character stats") {
    assertEquals(blackMage.name, "Saruman")
  }

  test("Checking hp"){
    assertEquals(blackMage.hp, 20)
  }

  test("Checking defense") {
    assertEquals(blackMage.defense, 10)
  }

  test("Checking weight") {
    assertEquals(blackMage.weight, 50)
  }

  test("Checking mp") {
    assertEquals(blackMage.mp, 95)
  }
  test("Testing temporary equipWeapon method") {
    blackMage.equipWeapon()
    assertEquals(blackMage.hasWeapon, true)
  }

  test("Testing temporary unequipWeapon method") {
    blackMage.unequipWeapon()
    assertEquals(blackMage.hasWeapon, false)
  }


}