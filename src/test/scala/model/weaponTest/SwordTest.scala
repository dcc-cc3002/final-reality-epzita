package model.weaponTest

import model.armory.Sword
import model.character.specializations.Warrior
import munit.FunSuite

class SwordTest extends FunSuite {
  var sword: Sword = _
  var testWarrior: Warrior = _

  override def beforeEach(context: BeforeEach): Unit = {
    sword = new Sword("Excalibur", 15, 10, 5)
    testWarrior = new Warrior("Guts", 20,10,10)
  }

  test("Checking correct asignment of weapon name") {
    assertEquals(sword.name, "Excalibur")
  }
  test("Checking correct asignment of weapon damage") {
    assertEquals(sword.getDamage, 15)
  }
  test("Checking correct asignment of weapon defense") {
    assertEquals(sword.getDefense, 10)
  }
  test("Checking correct asignment of weapon weight") {
    assertEquals(sword.weight, 5)
  }

  test("Checking Staff enhance method") {
    sword.sharp()
    assertEquals(sword.getDamage, 17)
  }

  test("Testing owner methods"){
    sword.setOwner(testWarrior)
    assertEquals(sword.owner, Some(testWarrior))
  }

  test("Same as above"){
    sword.setOwner(testWarrior)
    sword.leaveOwner()
    assertEquals(sword.owner, None)
  }

}