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
/**
 * Represents a Staff, a type of magic weapon in a role-playing game.
 *
 * @param name The name of the staff.
 * @param damage The base physical damage inflicted by the staff.
 * @param magicDamage The base magic damage inflicted by the staff.
 * @param defense The defense power of the staff.
 * @param weight The weight of the staff.
 */
class Staff(val name: String,
            protected var damage: Int,
            protected var magicDamage: Int,
            protected val defense: Int,
            val weight: Int) extends MagicWeapon {

  /**
   * Sets the owner of the staff to a White Mage.
   *
   * @param whiteMage The White Mage character to whom the staff will be assigned.
   * @throws Exception if the staff already has an owner.
   */
  def setOwner(whiteMage: WhiteMage): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(whiteMage)
    } else {
      throw new Exception("This weapon already has an owner")
    }
  }

  /**
   * Sets the owner of the staff to a Black Mage.
   *
   * @param blackMage The Black Mage character to whom the staff will be assigned.
   * @throws Exception if the staff already has an owner.
   */
  def setOwner(blackMage: BlackMage): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(blackMage)
    } else {
      throw new Exception("This weapon already has an owner")
    }
  }

  /**
   * Sets the owner of the staff to a Paladin.
   *
   * @param paladin The Paladin character who attempts to equip the staff.
   * @throws Exception since a staff cannot be equipped by a Paladin.
   */
  def setOwner(paladin: Paladin): Unit = {
    throw new Exception("Staff cannot be equipped by a Paladin")
  }

  /**
   * Sets the owner of the staff to a Warrior.
   *
   * @param warrior The Warrior character who attempts to equip the staff.
   * @throws Exception since a staff cannot be equipped by a Warrior.
   */
  def setOwner(warrior: Warrior): Unit = {
    throw new Exception("Staff cannot be equipped by a Warrior")
  }

  /**
   * Sets the owner of the staff to a Ninja.
   *
   * @param ninja The Ninja character who attempts to equip the staff.
   * @throws Exception since a staff cannot be equipped by a Ninja.
   */
  def setOwner(ninja: Ninja): Unit = {
    throw new Exception("Staff cannot be equipped by a Ninja")
  }
}

