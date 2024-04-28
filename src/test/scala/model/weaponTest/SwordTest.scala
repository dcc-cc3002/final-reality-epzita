package model.weaponTest

import model.armory.Sword
import munit.FunSuite

class SwordTest extends FunSuite {
  var sword: Sword = _

  override def beforeEach(context: BeforeEach): Unit = {
    sword = new Sword("Excalibur", 15, 10, 5)
  }

  test("Checking correct asignment of weapon name") {
    assertEquals(sword.name, "Excalibur")
  }
  test("Checking correct asignment of weapon damage") {
    assertEquals(sword.damage, 15)
  }
  test("Checking correct asignment of weapon defense") {
    assertEquals(sword.defense, 10)
  }
  test("Checking correct asignment of weapon weight") {
    assertEquals(sword.weight, 5)
  }

  test("Checking Staff enhance method") {
    sword.sharp()
    assertEquals(sword.getDamage(), 17)
  }

}