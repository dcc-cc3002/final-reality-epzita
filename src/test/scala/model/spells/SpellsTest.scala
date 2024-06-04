package model.character

import exceptions.{DeadUnitException, InsufficientManaException, WeaponNotFoundException}
import model.armory.Staff
import model.character.Enemy
import model.character.specializations.{BlackMage, WhiteMage}
import model.sorcery.{Fire, Heal, Paralize, Poison, Thunder}
import munit.FunSuite

class SpellsTest extends FunSuite{
  //mages
  var whiteMage: WhiteMage = _
  var blackMage: BlackMage = _
  var noobMage: WhiteMage = _
  var noobBlackMage: BlackMage = _
  //weapons & targets
  var staff: Staff = _
  var enemy: Enemy = _
  var deadEnemy: Enemy = _
  var deadMage: WhiteMage = _
  //spells
  var fire: Fire = _
  var heal: Heal = _
  var thunder: Thunder = _
  var paralize: Paralize = _
  var poison: Poison = _

  override def beforeEach(context: BeforeEach): Unit ={
    whiteMage = new WhiteMage("Gandalf", 15, 5, 60, 100)
    blackMage = new BlackMage("Saruman", 20, 10, 60, 100)
    noobMage = new WhiteMage("Potat", 10, 10, 10, 1)
    noobBlackMage = new BlackMage("Bad Potat", 10, 10, 10, 1)

    staff = new Staff("Stick", 10, 10,10,10)
    enemy = new Enemy("Sauron", 100, 10, 10, 10)
    deadEnemy = new Enemy("Dead", 0,1,1,1)
    deadMage = new WhiteMage("Dead Mage",0,1,1,1)
    fire = new Fire()
    heal = new Heal()
    thunder = new Thunder()
    paralize = new Paralize()
    poison = new Poison()

  }

  //Fire Spell Tests
  test("A Fire spell can be casted by a Black Mage with a Weapon equipped"){
    blackMage.equipWeapon(staff)
    val expected_hp = enemy.getHp - staff.getMagicDamage
    blackMage.castSpell(fire, enemy)
    assertEquals(enemy.getHp, expected_hp)
  }

  test("A Fire spell cannot be casted by a Black Mage without enough mana"){
    noobBlackMage.equipWeapon(staff)
    intercept[InsufficientManaException](noobBlackMage.castSpell(fire, enemy))
  }

  test("A Fire spell cannot be casted without a Weapon"){
    intercept[WeaponNotFoundException](blackMage.castSpell(fire,enemy))
  }

  test("A Fire spell cannot be casted by a White Mage"){
    whiteMage.equipWeapon(staff)
    intercept[Exception](whiteMage.castSpell(fire, enemy))
  }
  test("A Fire spell cannot be casted upon a dead Unit"){
    blackMage.equipWeapon(staff)
    intercept[DeadUnitException](blackMage.castSpell(fire,deadEnemy))
  }

  //Heal Spell Tests

  test("A Heal spell can be casted by a White Mage"){
    whiteMage.castSpell(heal, enemy)
    val expected_hp = 130
    assertEquals(enemy.getHp,130)
  }

  test("A heal spell cannot be casted by a Black Mage"){
    intercept[Exception](blackMage.castSpell(heal, enemy))
  }

  test("A spell cannot be casted by a Mage with insufficient mana"){
    intercept[InsufficientManaException](noobMage.castSpell(heal, enemy))
  }

  test("A Heal spell cannot be casted upon a dead Unit") {
    whiteMage.equipWeapon(staff)
    intercept[DeadUnitException](whiteMage.castSpell(heal, deadMage))
  }

  //Thunder Spell Tests
  test("A Thunder spell can be casted by a Black Mage with a Weapon equipped") {
    blackMage.equipWeapon(staff)
    val expected_hp = enemy.getHp - staff.getMagicDamage
    blackMage.castSpell(thunder, enemy)
    assertEquals(enemy.getHp, expected_hp)
  }

  test("A Thunder spell cannot be casted by a Black Mage without enough mana") {
    noobBlackMage.equipWeapon(staff)
    intercept[InsufficientManaException](noobBlackMage.castSpell(thunder, enemy))
  }

  test("A Thunder spell cannot be casted without a Weapon") {
    intercept[WeaponNotFoundException](blackMage.castSpell(thunder, enemy))
  }

  test("A Thunder spell cannot be casted by a White Mage") {
    whiteMage.equipWeapon(staff)
    intercept[Exception](whiteMage.castSpell(thunder, enemy))
  }

  test("A Thunder spell cannot be casted upon a dead Unit") {
    blackMage.equipWeapon(staff)
    intercept[DeadUnitException](blackMage.castSpell(thunder, deadEnemy))
  }

  //Paralize Spell Tests

  test("A Paralize spell can be casted by a White Mage with a Weapon equipped") {
    whiteMage.equipWeapon(staff)
    val expected_hp = enemy.getHp - staff.getMagicDamage
    whiteMage.castSpell(paralize, enemy)
    assertEquals(enemy.getHp, expected_hp)
  }

  test("A Paralize spell cannot be casted by a White Mage without enough mana") {
    noobMage.equipWeapon(staff)
    intercept[InsufficientManaException](noobMage.castSpell(paralize, enemy))
  }

  test("A Paralize spell cannot be casted without a Weapon") {
    intercept[WeaponNotFoundException](whiteMage.castSpell(paralize, enemy))
  }

  test("A Paralize spell cannot be casted by a Black Mage") {
    blackMage.equipWeapon(staff)
    intercept[Exception](blackMage.castSpell(paralize, enemy))
  }

  test("A Paralize spell cannot be casted upon a dead Unit") {
    whiteMage.equipWeapon(staff)
    intercept[DeadUnitException](whiteMage.castSpell(paralize, deadEnemy))
  }

  //Poison Spell Tests
  test("A Poison spell can be casted by a White Mage with a Weapon equipped") {
    whiteMage.equipWeapon(staff)
    val expected_hp = enemy.getHp - staff.getMagicDamage
    whiteMage.castSpell(poison, enemy)
    assertEquals(enemy.getHp, expected_hp)
  }

  test("A Poison spell cannot be casted by a White Mage without enough mana") {
    noobMage.equipWeapon(staff)
    intercept[InsufficientManaException](noobMage.castSpell(poison, enemy))
  }

  test("A Poison spell cannot be casted without a Weapon") {
    intercept[WeaponNotFoundException](whiteMage.castSpell(poison, enemy))
  }

  test("A Poison spell cannot be casted by a Black Mage") {
    blackMage.equipWeapon(staff)
    intercept[Exception](blackMage.castSpell(poison, enemy))
  }
  test("A Poison spell cannot be casted upon a dead Unit") {
    whiteMage.equipWeapon(staff)
    intercept[DeadUnitException](whiteMage.castSpell(poison, deadEnemy))
  }
}