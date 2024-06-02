package model.character

import exceptions.InvalidTargetException

/**
 * Abstract class representing an enemy in a role-playing game.
 *
 * This class defines the common properties and behavior of enemies in the game.
 */
abstract class AEnemy extends AGameUnit {
  def canBeAttackedBy(enemy: Enemy): Boolean = false
  def canBeAttackedBy(character: Character): Boolean = true


  /** The attack power of the enemy. */
  var attack: Int



  /**
   * Indicates whether this object is an enemy.
   *
   * @return `true` if this object is an enemy, `false` otherwise.
   *
   * @note This method has been implemented for the Enemy class to be instantiated and tested.
   */
  def isEnemy: Boolean = {
    true
  }
}


