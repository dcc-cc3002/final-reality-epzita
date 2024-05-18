package model.weaponTest

import model.armory.Wand
import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}
import munit.FunSuite

class WandTest extends FunSuite {
  var wand: Wand = _
  var holder: WhiteMage = _
  var warrior: Warrior = _
  var paladin: Paladin = _
  var ninja: Ninja = _
  var whiteMage: WhiteMage = _
  var blackMage: BlackMage = _

  override def beforeEach(context: BeforeEach): Unit = {
    wand = new Wand("Wand", 15, 10, 5, 10)
    holder = new WhiteMage("Holder",10,10,10,10)
    warrior = new Warrior("Warrior", 10, 10, 10)
    paladin = new Paladin("Paladin", 10, 10, 10)
    ninja = new Ninja("Ninja", 10, 10, 10)
    whiteMage = new WhiteMage("WhiteMage", 10, 10, 10, 10)
    blackMage = new BlackMage("BlackMage", 10, 10, 10, 10)
  }


  test("A Wand can be equipped by the next character(s): Ninja, BlackMage, WhiteMage") {
    ninja.equipWeapon(wand)
    wand.leaveOwner()
    blackMage.equipWeapon(wand)
    wand.leaveOwner()
    whiteMage.equipWeapon(wand)
  }

  test("A Wand cannot be equipped by the next character(s): Warrior, Paladin") {
    intercept[Exception](warrior.equipWeapon(wand))
    intercept[Exception](paladin.equipWeapon(wand))
  }

  test("A character that can equip a Wand cannot equip it if it already has an owner") {
    holder.equipWeapon(wand)
    intercept[Exception](blackMage.equipWeapon(wand))
    intercept[Exception](whiteMage.equipWeapon(wand))
    intercept[Exception](ninja.equipWeapon(wand))
  }

}

