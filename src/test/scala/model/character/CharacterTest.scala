package model.character

import exceptions.{InvalidStatException, WeaponNotFoundException}
import model.armory.Sword
import model.character.Enemy
import model.character.specializations.{Paladin, Warrior}
import munit.FunSuite


class CharacterTest extends FunSuite{
  var warrior: Warrior = _
  var sword: Sword = _
  var dummy: Paladin = _
  var woodenSword: Sword = _
  var warrior2: Warrior = _
  var enemy: Enemy = _

  override def beforeEach(context: BeforeEach): Unit ={
    warrior = new Warrior("Pepsita", 35, 8, 62)
    dummy = new Paladin("Dummy", 30,5,10)
    sword = new Sword("Excalibur", 10, 10,10)
    woodenSword = new Sword("Stick", 1, 10,10)
    enemy = new Enemy("Enemy", 10, 10, 5, 10)
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
    val damage = sword.getDamage - enemy.getDefense
    val expected = enemy.getHp - damage
    warrior.attack(enemy)
    assertEquals(enemy.getHp , expected)
  }
  test("If a character's defense is higher than the damage of the weapon attacking him, he doesn't receive damage") {
    warrior.equipWeapon(woodenSword)
    val expected = enemy.getHp
    warrior.attack(enemy)
    assertEquals(enemy.getHp, expected)
  }
  test("A character can't be initialized with negative Hp"){
    intercept[InvalidStatException](new Warrior("InvalidHpWarrior", -1,1 ,1))
  }
  test("A character can't be initialized with negative Hp") {
    intercept[InvalidStatException](new Warrior("InvalidDefenseWarrior", 1, -1, 1))
  }
  test("A character can't be initialized with negative Hp") {
    intercept[InvalidStatException](new Warrior("InvalidWeightWarrior",1,1,-1){})
  }

  test("A character can't attack without a weapon equipped"){
    intercept[WeaponNotFoundException](warrior.attack(enemy))
  }
  //How to make this test work?
  /**
  test("A character cannot attack another character"){
    warrior.equipWeapon(woodenSword)
    intercept(warrior.attack(dummy))
  }
  */
}