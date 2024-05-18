package model.weaponTest

import model.armory.{Axe, Sword}
import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}
import munit.FunSuite

class AxeTest extends FunSuite {
  var axe: Axe = _
  var holder: Warrior = _
  var testWarrior: Warrior = _
  var warrior: Warrior = _
  var paladin: Paladin = _
  var ninja: Ninja = _
  var whiteMage: WhiteMage = _
  var blackMage: BlackMage = _

  override def beforeEach(context: BeforeEach): Unit = {
    axe = new Axe("Axe", 15, 10, 5)
    holder = new Warrior("Holder", 10,10,10)
    warrior = new Warrior("Warrior", 10, 10 , 10)
    paladin = new Paladin("Paladin", 10, 10, 10)
    ninja = new Ninja("Ninja", 10, 10 ,10)
    whiteMage = new WhiteMage("WhiteMage", 10,10,10,10)
    blackMage = new BlackMage("BlackMage", 10,10,10, 10)
  }

  test("A Sword can be equipped by the next character(s): Warrior, Paladin") {
    warrior.equipWeapon(axe)
    axe.leaveOwner()
    paladin.equipWeapon(axe)
    axe.leaveOwner()

  }

  test("A Sword cannot be equipped by the next character(s): Ninja, BlackMage WhiteMage") {
    intercept[Exception](ninja.equipWeapon(axe))
    intercept[Exception](blackMage.equipWeapon(axe))
    intercept[Exception](whiteMage.equipWeapon(axe))
  }
  test("A character that can equip an Axe cannot equip it if it already has an owner") {
    holder.equipWeapon(axe)
    intercept[Exception](paladin.equipWeapon(axe))
    intercept[Exception](warrior.equipWeapon(axe))
  }


}
