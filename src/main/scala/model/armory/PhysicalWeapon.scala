package model.armory

import exceptions.Require
import model.character.Character
import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}

/**
 * Abstract class defining a physical weapon.
 *
 * This class represents weapons that deal physical damage and have defense and weight attributes.
 */
abstract class PhysicalWeapon extends Weapon {

  /** The name of the weapon. */
  val name: String

  /** The base damage inflicted by the weapon. */
  protected var damage: Int

  // Ensures damage cannot be initialized with a negative value
  protected var _damage: Int = Require.Stat(damage, "damage") atLeast(0)

  /** The defense power of the weapon. */
  protected val defense: Int

  // Ensures defense cannot be initialized with a negative value
  protected var _defense: Int = Require.Stat(defense, "defense") atLeast(0)

  /** The weight of the weapon. */
  val weight: Int

  // Ensures weight cannot be initialized with a negative value
  protected var _weight: Int = Require.Stat(weight, "weight") atLeast(0)

  /** The character who currently owns the weapon. */
  var owner: Option[Character] = None

  /**
   * Returns the damage inflicted by the weapon.
   *
   * @return The damage inflicted by the weapon.
   */
  override def getDamage: Int = {
    this.damage
  }

  /**
   * Returns the defense power of the weapon.
   *
   * @return The defense power of the weapon.
   */
  override def getDefense: Int = {
    this.defense
  }

  /**
   * Increases the damage of the weapon by the specified amount.
   *
   * @param num The amount by which to increase the damage.
   */
  def setDamage(num: Int): Unit = {
    this.damage += num
  }

  /**
   * Checks if the weapon has magic damage.
   *
   * @return False, as this is a physical weapon.
   */
  def hasMagicDamage: Boolean = false

  /**
   * Increases the damage of the weapon by 2, simulating sharpening the weapon.
   */
  def sharp(): Unit = {
    damage += 2
  }

  /**
   * Leaves the current owner of the weapon, making it available for another character to equip.
   */
  def leaveOwner(): Unit = {
    this.owner = None
  }

  /**
   * Placeholder method for setting the owner of the weapon to a specific type of character.
   * Implementation should be provided in concrete classes.
   */
  def setOwner(warrior: Warrior): Unit

  def setOwner(paladin: Paladin): Unit

  def setOwner(ninja: Ninja): Unit

  def setOwner(blackMage: BlackMage): Unit

  def setOwner(whiteMage: WhiteMage): Unit

  /**
   * Returns the amount of magic damage inflicted by the weapon.
   *
   * @return The magic damage inflicted by the weapon (always 0 for a physical weapon).
   */
  def getMagicDamage: Int = {
    0
  }
}

