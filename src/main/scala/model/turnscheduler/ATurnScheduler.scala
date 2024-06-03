package model.turnscheduler

import model.character.{Character, GameUnit}

import scala.collection.mutable.ArrayBuffer

/**
 * Abstract class implementing a turn scheduler for managing the order of characters in a battle.
 *
 * This class extends ITurnScheduler and provides basic functionality for managing turns in a battle.
 */
abstract class ATurnScheduler extends ITurnScheduler {
  /** The list of characters currently in the fight. */
  val fightingCharacters: ArrayBuffer[GameUnit] = new ArrayBuffer[GameUnit]
  /** The list of characters waiting for their turn. */
  val waitList: ArrayBuffer[GameUnit] = new ArrayBuffer[GameUnit]
  /** The list of characters scheduled to fight. */
  val fightList: ArrayBuffer[GameUnit] = new ArrayBuffer[GameUnit]

  /** The character currently taking their turn. */
  var turnCharacter: GameUnit = _

  /**
   * Adds a new character to the scheduler.
   *
   * @param character The character to add.
   */
  def addNewCharacter(character: GameUnit): Unit = {
    this.fightingCharacters.addOne(character)
  }

  /**
   * Removes a character from the scheduler.
   *
   * @param character The character to remove.
   */
  def removeCharacter(character: GameUnit): Unit = {
    val index = this.fightingCharacters.indexOf(character)
    if (index != -1) {
      this.fightingCharacters.remove(index)
    }
  }

  /**
   * Sets the maximum action bar value for the characters in the given list.
   *
   * @param characters The list of characters for which to set the maximum action bar value.
   */
  def setCharacterMaxActionBar(characters: ArrayBuffer[GameUnit]): Unit = {
    for (character <- characters) {
      character.setMaxActionBar()
    }
  }

  /**
   * Resets the action bar value for the characters in the given list.
   *
   * @param characters The list of characters for which to reset the action bar value.
   */
  def resetCharacterActionBar(characters: ArrayBuffer[GameUnit]): Unit = {
    for (character <- characters) {
      character.setActionBar(0)
    }
  }

  /**
   * Moves characters from the fighting list to the wait list.
   */
  def enqueueCharacters(): Unit = {
    for (character <- this.fightingCharacters) {
      this.waitList.addOne(character)
    }
  }

  /**
   * Removes characters from the wait list that are now in the fight list.
   */
  private def cleanWaitList(): Unit = {
    for (character <- this.fightList) {
      val index = this.waitList.indexOf(character)
      if (index != -1) {
        this.waitList.remove(index)
      }
    }
  }

  /**
   * Updates the action bar value for all characters in the wait list by increasing it by k.
   * Moves characters from the wait list to the fight list if their action bar value is equal to or greater than their maximum action bar value.
   * Cleans up the wait list by removing characters that are now in the fight list.
   *
   * @param k The amount by which to increase the action bar value.
   */
  def updateCharacterActionBar(k: Int): Unit = {
    for (character <- this.waitList) {
      character.setActionBar(character.getActionBar() + k)
      if (character.getActionBar >= character.getMaxActionBar) {
        this.fightList.addOne(character)
      }
    }
    this.cleanWaitList()
  }

  /**
   * Sets the character currently taking their turn to the first character in the fight list.
   * Prints a message if the fight list is empty.
   */
  def setTurnCharacter(): Unit = {
    if (this.fightList.nonEmpty) {
      this.turnCharacter = this.fightList(0)
    } else {
      println("This turn has not yet started")
    }
  }
}
