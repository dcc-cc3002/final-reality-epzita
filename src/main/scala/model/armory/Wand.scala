package model.armory

import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}

/**
 * Represents a Wand, a type of magic weapon in a role-playing game.
 *
 * @param name The name of the wand.
 * @param damage The base physical damage inflicted by the wand.
 * @param magicDamage The base magical damage inflicted by the wand.
 * @param defense The defense power of the wand.
 * @param weight The weight of the wand.
 */
class Wand(val name: String,
           protected var damage: Int,
           protected var magicDamage: Int,
           protected val defense: Int,
           val weight: Int) extends MagicWeapon {

  /**
   * Sets the owner of the wand to a Ninja.
   *
   * @param ninja The Ninja character to whom the wand will be assigned.
   * @throws Exception if the wand already has an owner.
   */
  def setOwner(ninja: Ninja): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(ninja)
    } else {
      throw new Exception("This weapon already has an owner")
    }
  }

  /**
   * Sets the owner of the wand to a White Mage.
   *
   * @param whiteMage The White Mage character to whom the wand will be assigned.
   * @throws Exception if the wand already has an owner.
   */
  def setOwner(whiteMage: WhiteMage): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(whiteMage)
    } else {
      throw new Exception("This weapon already has an owner")
    }
  }

  /**
   * Sets the owner of the wand to a Black Mage.
   *
   * @param blackMage The Black Mage character to whom the wand will be assigned.
   * @throws Exception if the wand already has an owner.
   */
  def setOwner(blackMage: BlackMage): Unit = {
    if (this.owner.isEmpty) {
      this.owner = Some(blackMage)
    } else {
      throw new Exception("This weapon already has an owner")
    }
  }

  /**
   * Sets the owner of the wand to a Paladin.
   *
   * @param paladin The Paladin character who attempts to equip the wand.
   * @throws Exception since a wand cannot be equipped by a Paladin.
   */
  def setOwner(paladin: Paladin): Unit = {
    throw new Exception("Wand cannot be equipped by a Paladin")
  }

  /**
   * Sets the owner of the wand to a Warrior.
   *
   * @param warrior The Warrior character who attempts to equip the wand.
   * @throws Exception since a wand cannot be equipped by a Warrior.
   */
  def setOwner(warrior: Warrior): Unit = {
    throw new Exception("Wand cannot be equipped by a Warrior")
  }
}

