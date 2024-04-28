package model.weaponTest

import model.armory.Staff
import munit.FunSuite

class StaffTest extends FunSuite {
  var staff: Staff = _

  override def beforeEach(context: BeforeEach): Unit = {
    staff = new Staff("Stick", 1, 10, 5, 3)
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

}
