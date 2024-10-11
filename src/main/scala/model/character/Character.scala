package model.character

import model.armory.Weapon


/**
 * Trait representing a character.
 *
 * This trait defines the common properties and behavior of characters in the game.
 */
trait Character extends GameUnit {

  /**
   * Checks if the character has a weapon equipped.
   *
   * @return true if the character has a weapon equipped, false otherwise.
   */
  def hasWeapon: Boolean

  /**
   * Retrieves the weapon currently equipped by the character, if any.
   *
   * @return An Option containing the equipped weapon, or None if no weapon is equipped.
   */
  def getWeapon: Option[Weapon]

  /**
   * Indicates if the character can cast light spells.
   *
   * @return true if the character can cast light spells, false otherwise.
   */
  def canCastLightSpell: Boolean = false

  /**
   * Indicates if the character can cast dark spells.
   *
   * @return true if the character can cast dark spells, false otherwise.
   */
  def canCastDarkSpell: Boolean = false

  /**
   * Equips the given weapon to the character.
   *
   * Must be implemented by concrete classes extending this trait.
   *
   * @param weapon The weapon to equip.
   */
  def equipWeapon(weapon: Weapon): Unit
}

