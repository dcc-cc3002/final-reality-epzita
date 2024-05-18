package model.armory

import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}

class Wand (val name: String,
            protected var damage: Int,
            protected var magicDamage: Int,
            protected val defense: Int,
            val weight: Int) extends MagicWeapon {

  def setOwner(ninja: Ninja): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(ninja)
    }
    else {
      throw new Exception("This weapon already has an owner")
    }
  }

  def setOwner(whiteMage: WhiteMage): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(whiteMage)
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

  def setOwner(paladin: Paladin): Unit = {
    if(this.owner.isEmpty){
      throw new Exception("Wand cannot be equipped by a Paladin")
    }
    else {
      throw new Exception("This weapon already has an owner")
    }
  }

  def setOwner(warrior: Warrior): Unit = {
    if(this.owner.isEmpty){
      throw new Exception("Wand cannot be equipped by a Warrior")
    }
    else {
      throw new Exception("This weapon already has an owner")
    }
  }

}
