package model.turnScheduler

import scala.collection.mutable.ArrayBuffer
import model.character.Character

/**
 * Trait defining a turn scheduler for managing the order of characters in a battle.
 *
 * This trait works with lists of characters to ensure a correct turn order.
 */
trait ITurnScheduler {
  /** The list of characters currently in the fight. */
  val fightingCharacters: ArrayBuffer[Character]
  /** The list of characters waiting for their turn. */
  val waitList: ArrayBuffer[Character]
  /** The list of characters scheduled to fight. */
  val fightList: ArrayBuffer[Character]

  /**
   * Adds a new character to the scheduler.
   *
   * @param character The character to add.
   */
  def addNewCharacter(character: Character): Unit

  /**
   * Removes a character from the scheduler.
   *
   * @param character The character to remove.
   */
  def removeCharacter(character: Character): Unit

  /**
   * Sets the maximum action bar value for the characters in the given list.
   *
   * @param characters The list of characters for which to set the maximum action bar value.
   */
  def setCharacterMaxActionBar(characters: ArrayBuffer[Character]): Unit

  /**
   * Resets the action bar value for the characters in the given list.
   *
   * @param characters The list of characters for which to reset the action bar value.
   */
  def resetCharacterActionBar(characters: ArrayBuffer[Character]): Unit

  /**
   * Updates the action bar value for all characters by increasing it by k.
   *
   * @param k The amount by which to increase the action bar value.
   */
  def updateCharacterActionBar(k: Int): Unit

}
