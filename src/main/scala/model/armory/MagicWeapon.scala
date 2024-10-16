package model.armory

import exceptions.Require
import model.character.specializations.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}
import model.character.{ACharacter, AMagicCharacter, Character}

/**
 * Abstract class defining a magic weapon in a role-playing game.
 *
 * This class extends Weapon and adds a magic damage parameter to the weapon.
 */
abstract class MagicWeapon extends Weapon with IMagicWeapon {

  /** The name of the weapon. */
  val name: String

  /** The base damage inflicted by the weapon. */
  protected var damage: Int

  // Ensures damage cannot be initialized with a negative value
  protected var _damage: Int = Require.Stat(damage, "damage") atLeast(0)

  /** The magic damage inflicted by the weapon. */
  protected var magicDamage: Int

  // Ensures magicDamage cannot be initialized with a negative value
  protected var _magicDamage: Int = Require.Stat(magicDamage, "magicDamage") atLeast(0)

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
   * Returns the physical damage inflicted by the weapon.
   *
   * @return The physical damage inflicted by the weapon.
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
   * Returns the magic damage inflicted by the weapon.
   *
   * @return The magic damage inflicted by the weapon.
   */
  def getMagicDamage: Int = {
    this.magicDamage
  }

  /**
   * Increases the magic damage of the weapon by the specified amount.
   *
   * @param num The amount by which to increase the magic damage.
   */
  def setMagicDamage(num: Int): Unit = {
    this.magicDamage += num
  }

  /**
   * Checks if the weapon has magic damage capabilities.
   *
   * @return True, as this is a magic weapon.
   */
  def hasMagicDamage: Boolean = true

  /**
   * Increases the magic damage of the weapon by 2, enhancing the weapon's magical capabilities.
   */
  def enhance(): Unit = {
    setMagicDamage(2)
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
   * Leaves the current owner of the weapon, making it available for another character to equip.
   */
  def leaveOwner(): Unit = {
    this.owner = None
  }
}

