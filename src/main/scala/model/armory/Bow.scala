package model.armory

import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}

class Bow(val name: String,
          protected var damage: Int,
          protected val defense: Int,
          val weight: Int) extends PhysicalWeapon {

  def setOwner(warrior: Warrior): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(warrior)
    }
  }

  def setOwner(ninja: Ninja): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(ninja)
    }
  }

  def setOwner(whiteMage: WhiteMage): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(whiteMage)
    }
  }

  def setOwner(paladin: Paladin): Unit = {
    if (this.owner.isEmpty) {
      throw new Exception("Bow cannot be equipped by a Paladin")
    }
  }

  def setOwner(blackMage: BlackMage): Unit = {
    if (this.owner.isEmpty) {
      throw new Exception("Bow cannot be equipped by a Black Mage")
    }
  }



}
