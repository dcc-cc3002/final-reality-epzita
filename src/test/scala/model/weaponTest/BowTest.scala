package model.weaponTest

import model.armory.Bow
import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}
import munit.FunSuite

class BowTest extends FunSuite {
  var bow: Bow = _
  var holder: Ninja = _
  var warrior: Warrior = _
  var paladin: Paladin = _
  var ninja: Ninja = _
  var whiteMage: WhiteMage = _
  var blackMage: BlackMage = _


  override def beforeEach(context: BeforeEach): Unit = {
    bow = new Bow("Bow", 15, 10, 5)
    holder = new Ninja("Holder",10,10,10)
    warrior = new Warrior("Warrior", 10, 10, 10)
    paladin = new Paladin("Paladin", 10, 10, 10)
    ninja = new Ninja("Ninja", 10, 10, 10)
    whiteMage = new WhiteMage("WhiteMage", 10, 10, 10, 10)
    blackMage = new BlackMage("BlackMage", 10, 10, 10, 10)
  }


  test("A Sword can be equipped by the next character(s): Warrior, Ninja, WhiteMage") {
    warrior.equipWeapon(bow)
    bow.leaveOwner()
    ninja.equipWeapon(bow)
    bow.leaveOwner()
    whiteMage.equipWeapon(bow)
  }

  test("A Sword cannot be equipped by the next character(s): Paladin, BlackMage") {
    intercept[Exception](paladin.equipWeapon(bow))
    intercept[Exception](blackMage.equipWeapon(bow))
  }

  test("A character that can equip a Bow cannot equip it if it already has an owner") {
    holder.equipWeapon(bow)
    intercept[Exception](ninja.equipWeapon(bow))
    intercept[Exception](whiteMage.equipWeapon(bow))
    intercept[Exception](warrior.equipWeapon(bow))
  }
}

