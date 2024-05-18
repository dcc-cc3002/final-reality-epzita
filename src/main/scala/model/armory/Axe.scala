package model.armory

import model.character
import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}

class Axe(val name: String,
          protected var damage: Int,
          protected val defense: Int,
          val weight: Int) extends PhysicalWeapon{

  def setOwner(paladin: Paladin): Unit = {
    if(this.owner.isEmpty) {
      this.owner = Some(paladin)
    }
    else {
      throw new Exception("This weapon already has an owner")
    }
  }

  def setOwner(warrior: Warrior): Unit = {
    if(this.owner.isEmpty){
      this.owner = Some(warrior)
    }
    else {
      throw new Exception("This weapon already has an owner")
    }
  }

  def setOwner(ninja: Ninja): Unit = {
    if (this.owner.isEmpty) {
      throw new Exception("Axe cannot be equipped by a Ninja")
    }
    else {
      throw new Exception("This weapon already has an owner")
    }
  }

  def setOwner(blackMage: BlackMage): Unit = {
    if (this.owner.isEmpty) {
      throw new Exception("Axe cannot be equipped by a Black Mage")
    }
  }

  def setOwner(whiteMage: WhiteMage): Unit = {
    if (this.owner.isEmpty) {
      throw new Exception("Axe cannot be equipped by a White Mage")
    }
  }
}
