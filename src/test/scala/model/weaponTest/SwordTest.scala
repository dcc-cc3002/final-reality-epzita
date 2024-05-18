package model.weaponTest

import exceptions.InvalidStatException
import model.armory.Sword
import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}
import munit.FunSuite

class SwordTest extends FunSuite {
  var sword: Sword = _
  var holder: Warrior = _
  var testWarrior: Warrior = _
  var warrior: Warrior = _
  var paladin: Paladin = _
  var ninja: Ninja = _
  var whiteMage: WhiteMage = _
  var blackMage: BlackMage = _

  override def beforeEach(context: BeforeEach): Unit = {
    sword = new Sword("Dragonslayer", 15, 10, 5)
    holder = new Warrior("Holder", 10,10,10)
    testWarrior = new Warrior("Guts", 20,10,10)
    warrior = new Warrior("Warrior", 10, 10 , 10)
    paladin = new Paladin("Paladin", 10, 10, 10)
    ninja = new Ninja("Ninja", 10, 10 ,10)
    whiteMage = new WhiteMage("WhiteMage", 10,10,10,10)
    blackMage = new BlackMage("BlackMage", 10,10,10, 10)
  }

  test("A weapon must have correctly set up its name") {
    assertEquals(sword.name, "Dragonslayer")
  }
  test("A weapon must have correctly set up its damage") {
    assertEquals(sword.getDamage, 15)
  }
  test("A weapon must have correctly set up its defense") {
    assertEquals(sword.getDefense, 10)
  }
  test("A weapon must have correctly set up its weight") {
    assertEquals(sword.weight, 5)
  }

  test("A physical weapon can sharp itself to gain a damage boost") {
    sword.sharp()
    assertEquals(sword.getDamage, 17)
  }

  test("A weapon can set its owner"){
    sword.setOwner(testWarrior)
    assertEquals(sword.owner, Some(testWarrior))
  }

  test("A weapon can leave its owner"){
    sword.setOwner(testWarrior)
    sword.leaveOwner()
    assertEquals(sword.owner, None)
  }
  test("A weapon damage cannot have negative damage"){
    intercept[InvalidStatException](new Sword("InvalidSword",-1,1,1))
  }
  test("A weapon damage cannot have negative defense") {
    intercept[InvalidStatException](new Sword("InvalidSword",1,-1,1))
  }
  test("A weapon damage cannot have negative weight") {
    intercept[InvalidStatException](new Sword("InvalidSword",1,1,-1))
  }

  test("A Sword can be equipped by the next character(s): Warrior, Paladin, Ninja, BlackMage"){
    warrior.equipWeapon(sword)
    sword.leaveOwner()
    paladin.equipWeapon(sword)
    sword.leaveOwner()
    ninja.equipWeapon(sword)
    sword.leaveOwner()
    blackMage.equipWeapon(sword)
  }

  test("A Sword cannot be equipped by the next character(s): WhiteMage"){
    intercept[Exception](whiteMage.equipWeapon(sword))
  }

  test("A character that can equip a Sword cannot equip it if it already has an owner") {
    holder.equipWeapon(sword)
    intercept[Exception](paladin.equipWeapon(sword))
    intercept[Exception](ninja.equipWeapon(sword))
    intercept[Exception](blackMage.equipWeapon(sword))
    intercept[Exception](warrior.equipWeapon(sword))
  }


}