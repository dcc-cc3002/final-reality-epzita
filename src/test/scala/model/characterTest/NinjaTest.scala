package model.characterTest

import model.character.specializations.Ninja
import munit.FunSuite

class NinjaTest extends FunSuite{
  var ninja: Ninja = _


  override def beforeEach(context: BeforeEach): Unit ={
    ninja = new Ninja("Naruto", 20, 15, 70)
  }
  test("Checking correct asignment of character stats") {
    assertEquals(ninja.name, "Naruto")
  }

  test("Checking hp"){
    assertEquals(ninja.hp, 20)
  }

  test("Checking defense") {
    assertEquals(ninja.defense, 15)
  }

  test("Checking weight") {
    assertEquals(ninja.weight, 70)
  }
  test("Testing temporary equipWeapon method") {
    ninja.equipWeapon()
    assertEquals(ninja.hasWeapon, true)
  }

  test("Testing temporary unequipWeapon method") {
    ninja.unequipWeapon()
    assertEquals(ninja.hasWeapon, false)
  }

}