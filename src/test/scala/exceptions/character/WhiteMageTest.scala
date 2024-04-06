package exceptions.character

import character.specializations.WhiteMage
import munit.FunSuite

class WhiteMageTest extends FunSuite{
  var whiteMage: WhiteMage = _


  override def beforeEach(context: BeforeEach): Unit ={
    whiteMage = new WhiteMage("Gandalf", 15, 5, 60, 100)
  }
  test("Checking correct asignment of enemy stats") {
    assertEquals(whiteMage.name, "Gandalf")
  }

  test("Checking hp"){
    assertEquals(whiteMage.hp, 15)
  }

  test("Checking hp") {
    assertEquals(whiteMage.defense, 5)
  }

  test("Checking hp") {
    assertEquals(whiteMage.weight, 60)
  }

  test("Checking hp") {
    assertEquals(whiteMage.mp, 100)
  }


}