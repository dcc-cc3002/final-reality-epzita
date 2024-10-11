package model.character

import model.effects.EffectHandler

/**
 * Trait representing a game unit.
 *
 * This trait defines common properties and behaviors shared by characters and enemies in the game.
 */
trait GameUnit {

  /**
   * Returns the maximum value of the action bar for the game unit.
   *
   * @return The maximum value of the action bar.
   */
  def getMaxActionBar(): Int

  /**
   * Sets the maximum value of the action bar for the game unit.
   */
  def setMaxActionBar(): Unit

  /**
   * Returns the current value of the action bar for the game unit.
   *
   * @return The current value of the action bar.
   */
  def getActionBar(): Int

  /**
   * Sets the current value of the action bar for the game unit.
   *
   * @param actionBar The new value of the action bar.
   */
  def setActionBar(actionBar: Int)

  /**
   * Returns the current hit points of the game unit.
   *
   * @return The current hit points of the game unit.
   */
  def getHp: Int

  /**
   * Sets the hit points of the game unit to the given value.
   *
   * @param hp The new hit points value.
   */
  def setHp(hp: Int): Unit

  /**
   * Returns the defense power of the game unit.
   *
   * @return The defense power of the game unit.
   */
  def getDefense: Int

  /**
   * Determines if the game unit can be attacked by the given enemy.
   *
   * @param enemy The enemy attempting to attack.
   * @return true if the game unit can be attacked by the enemy, false otherwise.
   */
  def canBeAttackedBy(enemy: Enemy): Boolean

  /**
   * Determines if the game unit can be attacked by the given character.
   *
   * @param character The character attempting to attack.
   * @return true if the game unit can be attacked by the character, false otherwise.
   */
  def canBeAttackedBy(character: Character): Boolean

  /**
   * Attacks the given target game unit.
   *
   * @param target The target game unit to attack.
   */
  def attack(target: GameUnit): Unit

  /**
   * Indicates if the game unit is healable.
   *
   * @return true if the game unit can be healed, false otherwise.
   */
  def isHealeable: Boolean

  /**
   * Indicates if the game unit is damageable.
   *
   * @return true if the game unit can take damage, false otherwise.
   */
  def isDamageable: Boolean

  /**
   * Returns the effect handler associated with the game unit.
   *
   * @return The effect handler instance.
   */
  def getEffectHandler: EffectHandler
}

