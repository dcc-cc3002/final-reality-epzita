package exceptions.character

import character.specializations.Ninja
import munit.FunSuite

class NinjaTest extends FunSuite{
  var ninja: Ninja = _


  override def beforeEach(context: BeforeEach): Unit ={
    ninja = new Ninja("Naruto", 20, 15, 70)
  }
  test("Checking correct asignment of enemy stats") {
    assertEquals(ninja.name, "Naruto")
  }

  test("Checking hp"){
    assertEquals(ninja.hp, 20)
  }

  test("Checking hp") {
    assertEquals(ninja.defense, 15)
  }

  test("Checking hp") {
    assertEquals(ninja.weight, 70)
  }

}