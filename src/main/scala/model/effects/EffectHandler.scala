package model.effects

import model.character.{Enemy, GameUnit}

/**
 * Class handling the detrimental effects on characters during combat
 *
 * This class manages effects such as poison, burn, and paralysis, tracking their duration and damage.
 *
 * @param affected The game unit affected by the detrimental effects.
 */
class EffectHandler(affected: GameUnit) {
  /** The number of turns left for the poison effect. */
  private var poisonTurnsLeft: Int = 0
  /** The number of turns left for the burn effect. */
  private var burnedTurnsLeft: Int = 0
  /** The number of turns left for the paralysis effect. */
  private var paralizedTurnsLeft: Int = 0
  /** The damage inflicted per turn by the burn effect. */
  private var burnDamage: Int = 0
  /** The damage inflicted per turn by the poison effect. */
  private var poisonDamage: Int = 0

  /**
   * Returns the number of turns left for the poison effect.
   *
   * @return The number of turns left for the poison effect.
   */
  def getPoisonTurnsLeft: Int = poisonTurnsLeft

  /**
   * Sets the number of turns left for the poison effect.
   *
   * @param turns The new number of turns left for the poison effect.
   */
  def setPoisonTurnsLeft(turns: Int): Unit = {
    poisonTurnsLeft = turns
  }

  /**
   * Returns the damage inflicted per turn by the poison effect.
   *
   * @return The poison damage per turn.
   */
  def getPoisonDamage: Int = poisonDamage

  /**
   * Sets the damage inflicted per turn by the poison effect.
   *
   * @param damage The new poison damage per turn.
   */
  def setPoisonDamage(damage: Int): Unit = poisonDamage = damage

  /**
   * Checks if the character is currently poisoned.
   *
   * @return true if the character is poisoned, false otherwise.
   */
  def isPoisoned: Boolean = getPoisonTurnsLeft > 0

  /**
   * Returns the number of turns left for the burn effect.
   *
   * @return The number of turns left for the burn effect.
   */
  def getBurnedTurnsLeft: Int = burnedTurnsLeft

  /**
   * Sets the number of turns left for the burn effect.
   *
   * @param turns The new number of turns left for the burn effect.
   */
  def setBurnedTurnsLeft(turns: Int): Unit = {
    burnedTurnsLeft = turns
  }

  /**
   * Returns the damage inflicted per turn by the burn effect.
   *
   * @return The burn damage per turn.
   */
  def getBurnDamage: Int = burnDamage

  /**
   * Sets the damage inflicted per turn by the burn effect.
   *
   * @param damage The new burn damage per turn.
   */
  def setBurnDamage(damage: Int): Unit = burnDamage = damage

  /**
   * Checks if the character is currently burned.
   *
   * @return true if the character is burned, false otherwise.
   */
  def isBurned: Boolean = getBurnedTurnsLeft > 0

  /**
   * Returns the number of turns left for the paralysis effect.
   *
   * @return The number of turns left for the paralysis effect.
   */
  def getParalizedTurnsLeft: Int = paralizedTurnsLeft

  /**
   * Sets the number of turns left for the paralysis effect.
   *
   * @param turns The new number of turns left for the paralysis effect.
   */
  def setParalizedTurnsLeft(turns: Int): Unit = {
    paralizedTurnsLeft = turns
  }

  /**
   * Checks if the character is currently paralyzed.
   *
   * @return true if the character is paralyzed, false otherwise.
   */
  def isParalized: Boolean = getParalizedTurnsLeft > 0
}
