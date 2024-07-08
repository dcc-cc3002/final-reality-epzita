package model.armory

import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}

/**
 * Represents a Bow, a type of physical weapon in a role-playing game.
 *
 * @param name The name of the bow.
 * @param damage The base damage inflicted by the bow.
 * @param defense The defense power of the bow.
 * @param weight The weight of the bow.
 */
class Bow(val name: String,
          protected var damage: Int,
          protected val defense: Int,
          val weight: Int) extends PhysicalWeapon {

  /**
   * Sets the owner of the bow to a Warrior.
   *
   * @param warrior The Warrior character to whom the bow will be assigned.
   * @throws Exception if the bow already has an owner.
   */
  def setOwner(warrior: Warrior): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(warrior)
    } else {
      throw new Exception("This weapon already has an owner")
    }
  }

  /**
   * Sets the owner of the bow to a Ninja.
   *
   * @param ninja The Ninja character to whom the bow will be assigned.
   * @throws Exception if the bow already has an owner.
   */
  def setOwner(ninja: Ninja): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(ninja)
    } else {
      throw new Exception("This weapon already has an owner")
    }
  }

  /**
   * Sets the owner of the bow to a White Mage.
   *
   * @param whiteMage The White Mage character to whom the bow will be assigned.
   * @throws Exception if the bow already has an owner.
   */
  def setOwner(whiteMage: WhiteMage): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(whiteMage)
    } else {
      throw new Exception("This weapon already has an owner")
    }
  }

  /**
   * Sets the owner of the bow to a Paladin.
   *
   * @param paladin The Paladin character who attempts to equip the bow.
   * @throws Exception since a bow cannot be equipped by a Paladin.
   */
  def setOwner(paladin: Paladin): Unit = {
    throw new Exception("Bow cannot be equipped by a Paladin")
  }

  /**
   * Sets the owner of the bow to a Black Mage.
   *
   * @param blackMage The Black Mage character who attempts to equip the bow.
   * @throws Exception since a bow cannot be equipped by a Black Mage.
   */
  def setOwner(blackMage: BlackMage): Unit = {
    throw new Exception("Bow cannot be equipped by a Black Mage")
  }
}

