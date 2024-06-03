package model.character

import model.armory.Weapon


/**
 * Trait representing a character.
 *
 * This trait defines the common properties and behavior of characters in the game.
 */
trait Character extends GameUnit {

  /**
 * Sets the maximum value of the action bar for the character based on its weight.
   */
  def setMaxActionBar(): Unit

  /**
 * Returns the current hit points of the character.
 *
 * @return The current hit points of the character.
   */
  def getHp: Int

  /**
 * Sets the hit points of the character to the given value.
 *
 * @param hp The new hit points value.
   */
  def setHp(hp: Int): Unit
  def hasWeapon: Boolean
  def getWeapon: Option[Weapon]

  /**
 * Returns the defense power of the character.
 *
 * @return The defense power of the character.
   */
  def getDefense: Int

  def canCastLightSpell: Boolean = false
  def canCastDarkSpell: Boolean = false

}
