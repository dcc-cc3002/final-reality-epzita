package model.character

import model.armory.Staff
import model.character.specializations.WhiteMage
import munit.FunSuite

class MagicCharacterTest extends FunSuite{
  var whiteMage: WhiteMage = _
  var staff: Staff = _

  override def beforeEach(context: BeforeEach): Unit ={
    whiteMage = new WhiteMage("Gandalf", 15, 5, 60, 100)
    staff = new Staff("Stick", 10, 10,10,10)
  }

  test("A magic character must have correctly set up its stats") {
    assertEquals(whiteMage.name, "Gandalf")
    assertEquals(whiteMage.getHp, 15)
    assertEquals(whiteMage.getDefense, 5)
    assertEquals(whiteMage.weight, 60)

    //A magic character has mana points
    assertEquals(whiteMage.getMp, 100)
  }

}