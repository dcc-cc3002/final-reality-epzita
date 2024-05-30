package model.character

import model.armory.Weapon


/**
 * Trait representing a character.
 *
 * This trait defines the common properties and behavior of characters in the game.
 */
trait Character extends GameUnit {
  /** The name of the character. */
  val name: String
  /** The current hit points of the character. */
  protected var hp: Int
  /** The defense power of the character. */
  protected var defense: Int
  /** The weight of the character, used for determining the maximum action bar value. */
  val weight: Int

  /** The maximum value of the action bar for the character. */
  var maxActionBar: Int
  /** The current value of the action bar for the character. */
  var actionBar: Int


  /**
 * Attacks the given character, reducing their hit points based on the character's attack and the target's defense.
 *
 * @param character The character to attack.
   */
  def attack(character: Enemy): Unit

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

  /**
 * Returns the defense power of the character.
 *
 * @return The defense power of the character.
   */
  def getDefense: Int

  def canCastLightSpell: Boolean = false
  def canCastDarkSpell: Boolean = false

}
