package exceptions.character

import character.specializations.Paladin
import munit.FunSuite

class PaladinTest extends FunSuite{
  var paladin: Paladin = _

  override def beforeEach(context: BeforeEach): Unit ={
    paladin = new Paladin("Belfor", 30, 10, 75)

  }
  test("Checking correct asignment of enemy stats") {
    assertEquals(paladin.name, "Belfor")
  }

  test("Checking hp"){
    assertEquals(paladin.hp, 30)
  }

  test("Checking hp") {
    assertEquals(paladin.defense, 10)
  }

  test("Checking hp") {
    assertEquals(paladin.weight, 75)
  }

}
