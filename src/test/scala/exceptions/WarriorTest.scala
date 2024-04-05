package exceptions

import character.specializations.BlackMage
import munit.FunSuite

class WarriorTest extends FunSuite{
  var warrior: BlackMage = _

  override def beforeEach(context: BeforeEach): Unit ={
    warrior = new BlackMage("Pepsita", 35, 8, 62)
  }
  test("Checking correct asignment of enemy stats") {
    assertEquals(warrior.name, "Pepsita")
  }

  test("Checking hp"){
    assertEquals(warrior.hp, 35)
  }

  test("Checking hp") {
    assertEquals(warrior.defense, 8)
  }

  test("Checking hp") {
    assertEquals(warrior.weight, 62)
  }

}
