package model.turnscheduler

import scala.collection.mutable.ArrayBuffer
import model.character.{Character, GameUnit}

/**
 * Trait defining a turn scheduler for managing the order of characters in a battle.
 *
 * This trait works with lists of characters to ensure a correct turn order.
 */
trait ITurnScheduler {

  /**
   * Adds a new character to the scheduler.
   *
   * @param character The character to add.
   */
  def addNewCharacter(character: GameUnit): Unit

  /**
   * Removes a character from the scheduler.
   *
   * @param character The character to remove.
   */
  def removeCharacter(character: GameUnit): Unit

  /**
   * Sets the maximum action bar value for the characters in the given list.
   *
   * @param characters The list of characters for which to set the maximum action bar value.
   */
  def setCharacterMaxActionBar(characters: ArrayBuffer[GameUnit]): Unit

  /**
   * Resets the action bar value for the characters in the given list.
   *
   * @param characters The list of characters for which to reset the action bar value.
   */
  def resetCharacterActionBar(characters: ArrayBuffer[GameUnit]): Unit

  /**
   * Updates the action bar value for all characters by increasing it by k.
   *
   * @param k The amount by which to increase the action bar value.
   */
  def updateCharacterActionBar(k: Int): Unit

}
