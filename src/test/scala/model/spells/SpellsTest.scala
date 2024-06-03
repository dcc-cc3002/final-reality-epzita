package model.characterTest

import exceptions.{InsufficientManaException, WeaponNotFoundException}
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
  //weapons
  var staff: Staff = _
  var enemy: Enemy = _
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
}