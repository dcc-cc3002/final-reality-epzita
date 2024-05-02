package model.characterTest

import model.armory.Sword
import model.character.specializations.Paladin
import munit.FunSuite

class PaladinTest extends FunSuite{
  var paladin: Paladin = _
  var sword: Sword = _
  override def beforeEach(context: BeforeEach): Unit ={
    paladin = new Paladin("Tyrion", 30, 10, 75)
    sword = new Sword("Excalibur", 10, 10,10)

  }
  test("Checking correct asignment of character stats") {
    assertEquals(paladin.name, "Tyrion")
  }

  test("Checking hp"){
    assertEquals(paladin.hp, 30)
  }

  test("Checking defense") {
    assertEquals(paladin.defense, 10)
  }

  test("Checking weight") {
    assertEquals(paladin.weight, 75)
  }

  test("Testing temporary equipWeapon method"){
    paladin.equipWeapon(sword)
    assertEquals(paladin.hasWeapon, true)
  }

  test("Testing temporary unequipWeapon method"){
    paladin.unequipWeapon()
    assertEquals(paladin.hasWeapon,false)
  }



}
