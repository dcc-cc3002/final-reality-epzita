package model.armory

import model.character.Character
import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}

/**
 * Trait representing a weapon in a role-playing game.
 */
trait Weapon {
  /** The name of the weapon. */
  val name: String
  /** The base damage inflicted by the weapon. */
  protected var damage: Int
  /** The defense power of the weapon. */
  protected val defense: Int
  /** The weight of the weapon. */
  val weight: Int

  /**
   * Sets the owner of the weapon to a Warrior.
   *
   * @param warrior The Warrior who will be the owner of the weapon.
   */
  def setOwner(warrior: Warrior): Unit

  /**
   * Sets the owner of the weapon to a Paladin.
   *
   * @param paladin The Paladin who will be the owner of the weapon.
   */
  def setOwner(paladin: Paladin): Unit

  /**
   * Sets the owner of the weapon to a Ninja.
   *
   * @param ninja The Ninja who will be the owner of the weapon.
   */
  def setOwner(ninja: Ninja): Unit

  /**
   * Sets the owner of the weapon to a BlackMage.
   *
   * @param blackMage The BlackMage who will be the owner of the weapon.
   */
  def setOwner(blackMage: BlackMage): Unit

  /**
   * Sets the owner of the weapon to a WhiteMage.
   *
   * @param whiteMage The WhiteMage who will be the owner of the weapon.
   */
  def setOwner(whiteMage: WhiteMage): Unit

  /**
   * Leaves the current owner of the weapon, making it available for another character to equip.
   */
  def leaveOwner(): Unit

  /**
   * Returns the damage inflicted by the weapon.
   *
   * @return The damage inflicted by the weapon.
   */
  def getDamage: Int

  /**
   * Returns the defense power of the weapon.
   *
   * @return The defense power of the weapon.
   */
  def getDefense: Int

  /**
   * Checks if the weapon has magic damage.
   *
   * @return true if the weapon has magic damage, false otherwise.
   */
  def hasMagicDamage: Boolean

  /**
   * Returns the magic damage inflicted by the weapon, if it has any.
   *
   * @return The magic damage inflicted by the weapon.
   */
  def getMagicDamage: Int
}

