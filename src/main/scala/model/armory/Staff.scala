package model.armory

import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}

/**
 *
 * @param name name of the staff
 * @param damage physical damage of the staff
 * @param magicDamage magic damage
 * @param defense defense stat
 * @param weight weight of the weapon, impacts turn position during combat
 */
class Staff(val name: String,
            protected var damage: Int,
            protected var magicDamage: Int,
            protected val defense: Int,
            val weight: Int) extends MagicWeapon {

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
    if (this.owner.isEmpty) {
      throw new Exception("Staff cannot be equipped by a Paladin")
    }
  }

  def setOwner(warrior: Warrior): Unit = {
    if (this.owner.isEmpty) {
      throw new Exception("Staff cannot be equipped by a Warrior")
    }

  }

  def setOwner(ninja: Ninja): Unit = {
    if (this.owner.isEmpty) {
      throw new Exception("Axe cannot be equipped by a Ninja")
    }
  }
}
