package model.characterTest

import model.armory.Sword
import model.character.specializations.Ninja
import munit.FunSuite

class PhysicalCharacterTest extends FunSuite{
  var ninja: Ninja = _

  override def beforeEach(context: BeforeEach): Unit ={
    ninja = new Ninja("Naruto", 20, 15, 70)
  }
  test("A physical damage character must have correctly set up its stats") {
    assertEquals(ninja.name, "Naruto")
    assertEquals(ninja.getHp, 20)
    assertEquals(ninja.getDefense, 15)
    assertEquals(ninja.weight, 70)
  }
}