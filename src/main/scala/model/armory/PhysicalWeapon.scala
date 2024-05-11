package model.armory

import model.character.Character

/**
 * Abstract class defining a physical weapon.
 *
 * This class helps create only physical type weapons.
 */
abstract class PhysicalWeapon extends Weapon {
  /** The name of the weapon. */
  val name: String
  /** The base damage inflicted by the weapon. */
  protected var damage: Int
  /** The defense power of the weapon. */
  protected val defense: Int
  /** The weight of the weapon. */
  val weight: Int

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
    this.damage = this.damage + num
  }

  /**
   * Increases the damage of the weapon by 2, simulating sharpening the weapon.
   */
  def sharp(): Unit = {
    damage += 2
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
