package model.character

import model.armory.Weapon


/**
 * Trait representing a character.
 *
 * This trait defines the common properties and behavior of characters in the game.
 */
trait Character extends GameUnit {

  def hasWeapon: Boolean
  def getWeapon: Option[Weapon]

  def canCastLightSpell: Boolean = false
  def canCastDarkSpell: Boolean = false

  def equipWeapon(weapon:Weapon): Unit

}
