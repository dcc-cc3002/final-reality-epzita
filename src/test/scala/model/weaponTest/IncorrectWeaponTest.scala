package model.weaponTest

import model.armory.{Axe, Staff, Sword}
import model.character.specializations.{Ninja, Paladin, WhiteMage}
import munit.FunSuite


class IncorrectWeaponTest extends FunSuite {
  var staff: Staff = _
  var mage: WhiteMage = _
  var paladin: Paladin = _
  var sword: Sword = _
  var axe: Axe = _
  var ninja: Ninja = _

  override def beforeEach(context: BeforeEach): Unit = {
    staff = new Staff("Stick", 1, 10, 5, 3)
    mage = new WhiteMage("Khadgar", 10, 20, 50, 100)
    paladin = new Paladin("Tyrion", 10, 10,10 )
    sword = new Sword("Sword", 1,1,1)
    axe = new Axe("Axe", 1,1,1)
    ninja = new Ninja("Ninja",1,1,1)
  }

  test("A paladin cannot equip a Staff"){
    paladin.equipWeapon(sword)
  }

  test("A white mage cant equip a Sword"){
    intercept[Exception](mage.equipWeapon(sword))
  }

  test("A Ninja can't equip an Axe"){
    intercept[Exception](ninja.equipWeapon(axe))
  }

}



