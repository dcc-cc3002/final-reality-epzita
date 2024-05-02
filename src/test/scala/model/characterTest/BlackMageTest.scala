package model.characterTest

import model.armory.Staff
import model.character.specializations.BlackMage
import munit.FunSuite

class BlackMageTest extends FunSuite{
  var blackMage: BlackMage = _
  var staff: Staff = _


  override def beforeEach(context: BeforeEach): Unit ={
    blackMage = new BlackMage("Saruman", 20, 10, 50, 95)
    staff = new Staff("staff", 1,1,1,1)
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
    blackMage.equipWeapon(staff)
    assertEquals(blackMage.hasWeapon, true)
  }

  test("Testing temporary unequipWeapon method") {
    blackMage.unequipWeapon()
    assertEquals(blackMage.hasWeapon, false)
  }

  test("Testing new version of equipWeapon method"){
    assertEquals(blackMage.weapon, None)
  }

  test("same as above"){
    blackMage.equipWeapon(staff)
    assertEquals(blackMage.weapon, Some(staff))
  }

  test("Testing unequipWeapon method"){
    blackMage.equipWeapon(staff)
    blackMage.unequipWeapon()
    assertEquals(blackMage.weapon, None)
  }

  test("Testing maxActionBar values"){
    assertEquals(blackMage.maxActionBar, blackMage.weight)
  }

  test("Testing maxActionBar change when equiping a weapon"){
    blackMage.equipWeapon(staff)
    var expected: Int = blackMage.weight + staff.weight
    assertEquals(blackMage.maxActionBar, expected)
  }


}