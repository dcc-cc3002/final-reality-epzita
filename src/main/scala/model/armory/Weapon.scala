package model.armory

import model.character.Character
import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}

/**
 * Trait defining a weapon in a role-playing game.
 *
 * This trait helps create different kinds of weapon classes and represents every weapon in the game.
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


  def setOwner(warrior: Warrior): Unit
  def setOwner(paladin: Paladin): Unit
  def setOwner(ninja: Ninja): Unit
  def setOwner(blackMage: BlackMage): Unit
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
}
