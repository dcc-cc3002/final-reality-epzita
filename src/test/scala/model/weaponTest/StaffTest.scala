package model.weaponTest

import exceptions.InvalidStatException
import model.armory.Staff
import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}
import munit.FunSuite

class StaffTest extends FunSuite {
  var staff: Staff = _
  var holder: WhiteMage =_
  var mage: WhiteMage = _
  var warrior: Warrior = _
  var paladin: Paladin = _
  var ninja: Ninja = _
  var whiteMage: WhiteMage = _
  var blackMage: BlackMage = _

  override def beforeEach(context: BeforeEach): Unit = {
    staff = new Staff("Stick", 1, 10, 5, 3)
    holder = new WhiteMage("Holder", 10,10,10,10)
    mage = new WhiteMage("Khadgar", 10,20, 50, 100)
    warrior = new Warrior("Warrior", 10, 10, 10)
    paladin = new Paladin("Paladin", 10, 10, 10)
    ninja = new Ninja("Ninja", 10, 10, 10)
    whiteMage = new WhiteMage("WhiteMage", 10, 10, 10, 10)
    blackMage = new BlackMage("BlackMage", 10, 10, 10, 10)

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

  test("A Staff can be equipped by the next character(s): WhiteMage, BlackMage") {
    whiteMage.equipWeapon(staff)
    staff.leaveOwner()
    blackMage.equipWeapon(staff)

  }

  test("A Staff cannot be equipped by the next character(s): Warrior, Paladin, Ninja") {
    intercept[Exception](warrior.equipWeapon(staff))
    intercept[Exception](paladin.equipWeapon(staff))
    intercept[Exception](ninja.equipWeapon(staff))
  }

  test("A character that can equip a Staff cannot equip it if it already has an owner") {
    holder.equipWeapon(staff)
    intercept[Exception](blackMage.equipWeapon(staff))
    intercept[Exception](whiteMage.equipWeapon(staff))
  }

}
