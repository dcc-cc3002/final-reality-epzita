package model.armory

import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}

/**
 * Represents a Sword, a type of physical weapon in a role-playing game.
 *
 * @param name The name of the sword.
 * @param damage The base damage inflicted by the sword.
 * @param defense The defense power of the sword.
 * @param weight The weight of the sword.
 */
class Sword(val name: String,
            protected var damage: Int,
            protected val defense: Int,
            val weight: Int) extends PhysicalWeapon {

  /**
   * Sets the owner of the sword to a Warrior.
   *
   * @param warrior The Warrior character to whom the sword will be assigned.
   * @throws Exception if the sword already has an owner.
   */
  def setOwner(warrior: Warrior): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(warrior)
    } else {
      throw new Exception("This weapon already has an owner")
    }
  }

  /**
   * Sets the owner of the sword to a Paladin.
   *
   * @param paladin The Paladin character to whom the sword will be assigned.
   * @throws Exception if the sword already has an owner.
   */
  def setOwner(paladin: Paladin): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(paladin)
    } else {
      throw new Exception("This weapon already has an owner")
    }
  }

  /**
   * Sets the owner of the sword to a Ninja.
   *
   * @param ninja The Ninja character to whom the sword will be assigned.
   * @throws Exception if the sword already has an owner.
   */
  def setOwner(ninja: Ninja): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(ninja)
    } else {
      throw new Exception("This weapon already has an owner")
    }
  }

  /**
   * Sets the owner of the sword to a Black Mage.
   *
   * @param blackMage The Black Mage character to whom the sword will be assigned.
   * @throws Exception if the sword already has an owner.
   */
  def setOwner(blackMage: BlackMage): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(blackMage)
    } else {
      throw new Exception("This weapon already has an owner")
    }
  }

  /**
   * Sets the owner of the sword to a White Mage.
   *
   * @param whiteMage The White Mage character who attempts to equip the sword.
   * @throws Exception since a sword cannot be equipped by a White Mage.
   */
  def setOwner(whiteMage: WhiteMage): Unit = {
    throw new Exception("Sword cannot be equipped by a White Mage")
  }
}

