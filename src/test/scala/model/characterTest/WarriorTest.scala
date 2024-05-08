package model.characterTest

import model.armory.Sword
import model.character.specializations.{Paladin, Warrior}
import munit.FunSuite


class WarriorTest extends FunSuite{
  var warrior: Warrior = _
  var sword: Sword = _
  var dummy: Paladin = _
  var woodenSword: Sword = _
  override def beforeEach(context: BeforeEach): Unit ={
    warrior = new Warrior("Pepsita", 35, 8, 62)
    dummy = new Paladin("Dummy", 30,5,10)
    sword = new Sword("Excalibur", 10, 10,10)
    woodenSword = new Sword("Stick", 1, 10,10)
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
  test("A character with a weapon equipped can attack another character"){
    warrior.equipWeapon(sword)
    val damage = sword.damage - dummy.defense
    val expected = dummy.hp - damage
    warrior.attack(dummy)
    assertEquals(dummy.hp , expected)
  }
  test("If a character's defense is higher than the damage of the weapon attacking him, he doesn't receive damage") {
    warrior.equipWeapon(woodenSword)
    val expected = dummy.hp
    val damage = woodenSword.damage - dummy.defense
    warrior.attack(dummy)
    assertEquals(dummy.hp, expected)
  }

}
