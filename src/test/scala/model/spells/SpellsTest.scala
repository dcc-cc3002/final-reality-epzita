package model.character

import exceptions.{DeadUnitException, InsufficientManaException, InvalidTargetException, InvalidWeaponException, WeaponNotFoundException}
import model.armory.{Bow, Staff, Sword}
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
  var sword: Sword = _
  var bow: Bow = _
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
    sword = new Sword("Excalibur", 10, 10, 10)
    bow = new Bow("Bow", 10,10,10)
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

  test("A Fire spell cannot be casted upon an ally Unit") {
    blackMage.equipWeapon(staff)
    intercept[InvalidTargetException](blackMage.castSpell(fire, whiteMage))
  }

  test("A Fire spell cannot be casted without a Magic Weapon equipped") {
    blackMage.equipWeapon(sword)
    intercept[InvalidWeaponException](blackMage.castSpell(fire, enemy))
  }

  //Heal Spell Tests

  test("A Heal spell can be casted by a White Mage"){
    whiteMage.equipWeapon(staff)
    whiteMage.castSpell(heal, noobMage)
    val expected_hp = 13
    assertEquals(noobMage.getHp,expected_hp)
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

  test("A BuffSpell cannot be casted upon an Enemy Unit"){
    whiteMage.equipWeapon(staff)
    intercept[InvalidTargetException](whiteMage.castSpell(heal,enemy))
  }

  test("A Heal spell cannot be casted without a Magic Weapon equipped") {
    whiteMage.equipWeapon(bow)
    intercept[InvalidWeaponException](whiteMage.castSpell(heal, blackMage))
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

  test("A Thunder spell cannot be casted upon an ally Unit"){
    blackMage.equipWeapon(staff)
    intercept[InvalidTargetException](blackMage.castSpell(thunder,whiteMage))
  }
  test("A Thunder spell cannot be casted without a Magic Weapon equipped") {
    blackMage.equipWeapon(sword)
    intercept[InvalidWeaponException](blackMage.castSpell(thunder, enemy))
  }

  //Paralize Spell Tests

  test("A Paralize spell can be casted by a White Mage with a Weapon equipped") {
    whiteMage.equipWeapon(staff)
    whiteMage.castSpell(paralize, enemy)
    assert(enemy.getEffectHandler.isParalized, true)
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
  test("A Paralize spell cannot be casted upon an ally Unit") {
    whiteMage.equipWeapon(staff)
    intercept[InvalidTargetException](whiteMage.castSpell(paralize, blackMage))
  }
  test("A Paralize spell cannot be casted without a Magic Weapon equipped") {
    whiteMage.equipWeapon(bow)
    intercept[InvalidWeaponException](whiteMage.castSpell(paralize, enemy))
  }

  //Poison Spell Tests
  test("A Poison spell can be casted by a White Mage with a Weapon equipped") {
    whiteMage.equipWeapon(staff)
    val expected_hp = enemy.getHp - staff.getMagicDamage
    whiteMage.castSpell(poison, enemy)
    assertEquals(enemy.getHp, expected_hp)
  }

  test("A Poison spell poisons the target") {
    whiteMage.equipWeapon(staff)
    whiteMage.castSpell(poison, enemy)
    val expected_poison_damage = staff.getMagicDamage / 3
    assert(enemy.getEffectHandler.isPoisoned, true)
    assertEquals(enemy.getEffectHandler.getPoisonDamage, expected_poison_damage)
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
  test("A Poison spell cannot be casted upon an ally Unit") {
    whiteMage.equipWeapon(staff)
    intercept[InvalidTargetException](whiteMage.castSpell(poison, blackMage))
  }
  test("A Poison spell cannot be casted without a Magic Weapon equipped"){
    whiteMage.equipWeapon(bow)
    intercept[InvalidWeaponException](whiteMage.castSpell(poison, enemy))
  }
}