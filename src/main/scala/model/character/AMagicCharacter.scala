package model.character

import model.armory.Weapon


/**
 * Abstract class extending ACharacter, designed for implementing Mage characters.
 *
 * This class adds the mana points (mp) attribute to the character.
 */
abstract class AMagicCharacter extends ACharacter {
  /** The name of the character. */
  val name: String
  /** The current hit points of the character. */
  protected var hp: Int
  /** The defense power of the character. */
  protected var defense: Int
  /** The weight of the character, used for determining the maximum action bar value. */
  val weight: Int
  /** The current mana points of the character. */
  protected var mp: Int

  /**
   * Returns the current mana points of the character.
   *
   * @return The current mana points of the character.
   */
  def getMp: Int = {
    this.mp
  }

  def setMp(newMana: Int): Unit = {
    this.mp = newMana
  }
}
