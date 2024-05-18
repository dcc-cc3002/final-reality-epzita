package model.armory

import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}

/**
 *
 * @param name name of the sword
 * @param damage damage of the sword
 * @param defense defense stat
 * @param weight weight of the weapon, affects turn position during combat
 */
class Sword(val name: String,
            protected var damage: Int,
            protected val defense: Int,
            val weight: Int) extends PhysicalWeapon {
  def setOwner(warrior: Warrior): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(warrior)
    }
    else {
      throw new Exception("This weapon already has an owner")
    }
  }

  def setOwner(paladin: Paladin): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(paladin)
    }
    else {
      throw new Exception("This weapon already has an owner")
    }
  }

  def setOwner(ninja: Ninja): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(ninja)
    }
    else {
      throw new Exception("This weapon already has an owner")
    }
  }

  def setOwner(blackMage: BlackMage): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(blackMage)
    }
    else {
      throw new Exception("This weapon already has an owner")
    }
  }

  def setOwner(whiteMage: WhiteMage): Unit = {
    if(this.owner.isEmpty){
      throw new Exception("Sword cannot be equipped by a White Mage")
    }
    else {
      throw new Exception("This weapon already has an owner")
    }
  }



}
