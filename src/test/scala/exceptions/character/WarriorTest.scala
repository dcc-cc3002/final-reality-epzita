package exceptions.character

import character.specializations.Warrior
import munit.FunSuite


class WarriorTest extends FunSuite{
  var warrior: Warrior = _

  override def beforeEach(context: BeforeEach): Unit ={
    warrior = new Warrior("Pepsita", 35, 8, 62)
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
