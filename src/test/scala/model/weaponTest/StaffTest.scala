package model.weaponTest

import exceptions.InvalidStatException
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

  test("A magic weapon must set its name correctly") {
    assertEquals(staff.name, "Stick")
  }
  test("A magic weapon must set its weight correctly") {
    assertEquals(staff.getDamage, 1)
  }
  test("A magic weapon must set its weight correctly") {
    assertEquals(staff.getMagicDamage, 10)
  }
  test("A magic weapon must set its weight correctly") {
    assertEquals(staff.getDefense, 5)
  }
  test("A magic weapon must set its weight correctly") {
    assertEquals(staff.weight, 3)
  }
  test("A magic weapon can enhance its magic damage") {
    staff.enhance()
    assertEquals(staff.getMagicDamage, 12)
  }
  test("A weapon can set its owner"){
    staff.setOwner(mage)
    assertEquals(staff.owner, Some(mage))
  }
  test("A weapon can leave its owner"){
    staff.setOwner(mage)
    staff.leaveOwner()
    assertEquals(staff.owner, None)
  }
  test("A weapon cannot have negative damage"){
    intercept[InvalidStatException](new Staff("InvalidStaff", -1,1,1,1))

  }
  test("A magic weapon cannot have negative magic damage"){
    intercept[InvalidStatException](new Staff("InvalidStaff", 1,-1,1,1))
  }
  test("A weapon cannot have negative defense"){
    intercept[InvalidStatException](new Staff("InvalidStaff", 1,1,-1,1))
  }
  test("A weapon cannot have negative weight"){
    intercept[InvalidStatException](new Staff("InvalidStaff", 1,1,1,-1))
  }

}
