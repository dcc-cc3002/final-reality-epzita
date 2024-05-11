package model.weaponTest

import exceptions.InvalidStatException
import model.armory.Sword
import model.character.specializations.Warrior
import munit.FunSuite

class SwordTest extends FunSuite {
  var sword: Sword = _
  var testWarrior: Warrior = _

  override def beforeEach(context: BeforeEach): Unit = {
    sword = new Sword("Dragonslayer", 15, 10, 5)
    testWarrior = new Warrior("Guts", 20,10,10)
  }

  test("A weapon must have correctly set up its name") {
    assertEquals(sword.name, "Dragonslayer")
  }
  test("A weapon must have correctly set up its damage") {
    assertEquals(sword.getDamage, 15)
  }
  test("A weapon must have correctly set up its defense") {
    assertEquals(sword.getDefense, 10)
  }
  test("A weapon must have correctly set up its weight") {
    assertEquals(sword.weight, 5)
  }

  test("A physical weapon can sharp itself to gain a damage boost") {
    sword.sharp()
    assertEquals(sword.getDamage, 17)
  }

  test("A weapon can set its owner"){
    sword.setOwner(testWarrior)
    assertEquals(sword.owner, Some(testWarrior))
  }

  test("A weapon can leave its owner"){
    sword.setOwner(testWarrior)
    sword.leaveOwner()
    assertEquals(sword.owner, None)
  }
  test("A weapon damage cannot have negative damage"){
    intercept[InvalidStatException](new Sword("InvalidSword",-1,1,1))
  }
  test("A weapon damage cannot have negative defense") {
    intercept[InvalidStatException](new Sword("InvalidSword",1,-1,1))
  }
  test("A weapon damage cannot have negative weight") {
    intercept[InvalidStatException](new Sword("InvalidSword",1,1,-1))
  }


}