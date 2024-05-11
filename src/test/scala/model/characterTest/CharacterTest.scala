package model.characterTest

import model.armory.Sword
import model.character.specializations.{Paladin, Warrior}
import munit.FunSuite


class CharacterTest extends FunSuite{
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
  test("A character must have correctly set up its stats") {
    assertEquals(warrior.name, "Pepsita")
    assertEquals(warrior.getHp, 35)
    assertEquals(warrior.getDefense, 8)
    assertEquals(warrior.weight, 62)
  }

  test("A character can equip a weapon") {
    warrior.equipWeapon(sword)
    assertEquals(warrior.hasWeapon, true)
  }

  test("A character can unequip its weapon") {
    warrior.unequipWeapon()
    assertEquals(warrior.hasWeapon, false)
  }
  test("A character with a weapon equipped can attack another character"){
    warrior.equipWeapon(sword)
    val damage = sword.getDamage - dummy.getDefense
    val expected = dummy.getHp - damage
    warrior.attack(dummy)
    assertEquals(dummy.getHp , expected)
  }
  test("If a character's defense is higher than the damage of the weapon attacking him, he doesn't receive damage") {
    warrior.equipWeapon(woodenSword)
    val expected = dummy.getHp
    warrior.attack(dummy)
    assertEquals(dummy.getHp, expected)
  }

}