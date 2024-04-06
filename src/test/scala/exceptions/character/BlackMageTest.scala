package exceptions.character

import character.specializations.BlackMage
import munit.FunSuite

class BlackMageTest extends FunSuite{
  var blackMage: BlackMage = _


  override def beforeEach(context: BeforeEach): Unit ={
    blackMage = new BlackMage("Saruman", 20, 10, 50, 95)
  }
  test("Checking correct asignment of enemy stats") {
    assertEquals(blackMage.name, "Saruman")
  }

  test("Checking hp"){
    assertEquals(blackMage.hp, 20)
  }

  test("Checking hp") {
    assertEquals(blackMage.defense, 10)
  }

  test("Checking hp") {
    assertEquals(blackMage.weight, 50)
  }

  test("Checking hp") {
    assertEquals(blackMage.mp, 95)
  }


}