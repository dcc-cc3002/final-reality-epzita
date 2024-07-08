package model.armory

import model.character
import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}

/**
 * Represents an Axe, a type of physical weapon in a role-playing game.
 *
 * @param name The name of the axe.
 * @param damage The base damage inflicted by the axe.
 * @param defense The defense power of the axe.
 * @param weight The weight of the axe.
 */
class Axe(val name: String,
          protected var damage: Int,
          protected val defense: Int,
          val weight: Int) extends PhysicalWeapon {

  /**
   * Sets the owner of the axe to a Paladin.
   *
   * @param paladin The Paladin character to whom the axe will be assigned.
   * @throws Exception if the axe already has an owner.
   */
  def setOwner(paladin: Paladin): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(paladin)
    } else {
      throw new Exception("This weapon already has an owner")
    }
  }

  /**
   * Sets the owner of the axe to a Warrior.
   *
   * @param warrior The Warrior character to whom the axe will be assigned.
   * @throws Exception if the axe already has an owner.
   */
  def setOwner(warrior: Warrior): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(warrior)
    } else {
      throw new Exception("This weapon already has an owner")
    }
  }

  /**
   * Sets the owner of the axe to a Ninja.
   *
   * @param ninja The Ninja character who attempts to equip the axe.
   * @throws Exception since an axe cannot be equipped by a Ninja.
   */
  def setOwner(ninja: Ninja): Unit = {
    throw new Exception("Axe cannot be equipped by a Ninja")
  }

  /**
   * Sets the owner of the axe to a Black Mage.
   *
   * @param blackMage The Black Mage character who attempts to equip the axe.
   * @throws Exception since an axe cannot be equipped by a Black Mage.
   */
  def setOwner(blackMage: BlackMage): Unit = {
    throw new Exception("Axe cannot be equipped by a Black Mage")
  }

  /**
   * Sets the owner of the axe to a White Mage.
   *
   * @param whiteMage The White Mage character who attempts to equip the axe.
   * @throws Exception since an axe cannot be equipped by a White Mage.
   */
  def setOwner(whiteMage: WhiteMage): Unit = {
    throw new Exception("Axe cannot be equipped by a White Mage")
  }
}

