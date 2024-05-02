package model.characterTest

import model.armory.Sword
import model.character.specializations.Warrior
import munit.FunSuite


class WarriorTest extends FunSuite{
  var warrior: Warrior = _
  var sword: Sword = _

  override def beforeEach(context: BeforeEach): Unit ={
    warrior = new Warrior("Pepsita", 35, 8, 62)
    sword = new Sword("Excalibur", 10, 10,10)
  }
  test("Checking correct asignment of character stats") {
    assertEquals(warrior.name, "Pepsita")
  }

  test("Checking hp"){
    assertEquals(warrior.hp, 35)
  }

  test("Checking defense") {
    assertEquals(warrior.defense, 8)
  }

  test("Checking weight") {
    assertEquals(warrior.weight, 62)
  }
  test("Testing temporary equipWeapon method") {
    warrior.equipWeapon(sword)
    assertEquals(warrior.hasWeapon, true)
  }

  test("Testing temporary unequipWeapon method") {
    warrior.unequipWeapon()
    assertEquals(warrior.hasWeapon, false)
  }

}
