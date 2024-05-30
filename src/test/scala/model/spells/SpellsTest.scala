package model.characterTest

import model.armory.Staff
import model.character.Enemy
import model.character.specializations.{BlackMage, WhiteMage}
import model.sorcery.{Fire, Heal}
import munit.FunSuite

class SpellsTest extends FunSuite{
  //mages
  var whiteMage: WhiteMage = _
  var blackMage: BlackMage = _
  //weapons
  var staff: Staff = _
  var enemy: Enemy = _
  //spells
  var fire: Fire = _
  var heal: Heal = _

  override def beforeEach(context: BeforeEach): Unit ={
    whiteMage = new WhiteMage("Gandalf", 15, 5, 60, 100)
    blackMage = new BlackMage("Saruman", 20, 10, 60, 100)
    staff = new Staff("Stick", 10, 10,10,10)
    enemy = new Enemy("Sauron", 100, 10, 10, 10)
    fire = new Fire()
    heal = new Heal()

  }

  test("A Fire spell can be casted by a Black Mage with a Weapon equipped"){
    blackMage.equipWeapon(staff)
    val expected_hp = enemy.getHp - staff.getMagicDamage
    blackMage.castSpell(fire, enemy)
    assertEquals(enemy.getHp, expected_hp)
  }

  test("A Fire spell cannot be casted by a White Mage"){
    whiteMage.equipWeapon(staff)
    intercept[Exception](whiteMage.castSpell(fire, enemy))
  }

  test("A Heal spell can be casted by a White Mage"){
    whiteMage.castSpell(heal, enemy)
    val expected_hp = 130
    assertEquals(enemy.getHp,130)
  }
}