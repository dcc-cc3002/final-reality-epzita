package model.weaponTest

import model.armory.Staff
import model.character.specializations.WhiteMage
import munit.FunSuite

class StaffTest extends FunSuite {
  var staff: Staff = _
  var mage: WhiteMage = _

  override def beforeEach(context: BeforeEach): Unit = {
    staff = new Staff("Stick", 1, 10, 5, 3)
    mage = new WhiteMage("Khadgar", 10,20, 50, 100)

  }

  test("Checking correct asignment of weapon name") {
    assertEquals(staff.name, "Stick")
  }
  test("Checking correct asignment of weapon damage") {
    assertEquals(staff.damage, 1)
  }
  test("Checking correct asignment of weapon magic damage") {
    assertEquals(staff.magicDamage, 10)
  }
  test("Checking correct asignment of weapon defense") {
    assertEquals(staff.defense, 5)
  }
  test("Checking correct asignment of weapon weight") {
    assertEquals(staff.weight, 3)
  }
  test("Checking Staff enhance method") {
    staff.enhance()
    assertEquals(staff.getMagicDamage(), 12)
  }
  test("Testing setOwner method"){
    staff.setOwner(mage)
    assertEquals(staff.owner, Some(mage))
  }
  test("Testing leaveOwner method"){
    staff.setOwner(mage)
    staff.leaveOwner()
    assertEquals(staff.owner, None)
  }

}
