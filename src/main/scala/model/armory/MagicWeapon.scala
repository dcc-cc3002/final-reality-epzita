package model.armory

import model.character.{ACharacter, AMagicCharacter, Character}

/**
 * Abstract class defining a magic weapon in a role-playing game.
 *
 * This class extends Weapon and adds a magic damage parameter to the weapon.
 */
abstract class MagicWeapon extends Weapon {
  /** The name of the weapon. */
  val name: String
  /** The base damage inflicted by the weapon. */
  protected var damage: Int
  /** The magic damage inflicted by the weapon. */
  protected var magicDamage: Int
  /** The defense power of the weapon. */
  protected val defense: Int
  /** The weight of the weapon. */
  val weight: Int

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
    this.magicDamage = this.magicDamage + num
  }

  /**
   * Increases the magic damage of the weapon by 2, enhancing the weapon's magical capabilities.
   */
  def enhance(): Unit = {
    setMagicDamage(2)
  }

  /**
   * Sets the owner of the weapon to the given character.
   *
   * @param character The character who will become the owner of the weapon.
   */
  def setOwner(character: Character): Unit = {
    if (owner.isEmpty) {
      this.owner = Some(character)
    }
  }

  /**
   * Leaves the current owner of the weapon, making it available for another character to equip.
   */
  def leaveOwner(): Unit = {
    this.owner = None
  }
}
