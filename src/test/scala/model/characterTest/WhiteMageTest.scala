package model.characterTest

import model.armory.Staff
import model.character.specializations.WhiteMage
import munit.FunSuite

class WhiteMageTest extends FunSuite{
  var whiteMage: WhiteMage = _
  var staff: Staff = _


  override def beforeEach(context: BeforeEach): Unit ={
    whiteMage = new WhiteMage("Gandalf", 15, 5, 60, 100)
    staff = new Staff("Stick", 10, 10,10,10)
  }
  test("Checking correct asignment of character stats") {
    assertEquals(whiteMage.name, "Gandalf")
  }

  test("Checking hp"){
    assertEquals(whiteMage.hp, 15)
  }

  test("Checking defense") {
    assertEquals(whiteMage.defense, 5)
  }

  test("Checking weight") {
    assertEquals(whiteMage.weight, 60)
  }

  test("Checking mp") {
    assertEquals(whiteMage.mp, 100)
  }
  test("Testing temporary equipWeapon method") {
    whiteMage.equipWeapon(staff)
    assertEquals(whiteMage.hasWeapon, true)
  }

  test("Testing temporary unequipWeapon method") {
    whiteMage.unequipWeapon()
    assertEquals(whiteMage.hasWeapon, false)
  }


}