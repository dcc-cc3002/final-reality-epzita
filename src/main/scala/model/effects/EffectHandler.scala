package model.effects

import model.character.{Enemy, GameUnit}

/**
 * Class handling detrimental effects on characters during combat.
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
  private var paralyzedTurnsLeft: Int = 0
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
    poisonTurnsLeft = math.max(0, turns)
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
  def setPoisonDamage(damage: Int): Unit = {
    poisonDamage = damage
  }

  /**
   * Checks if the character is currently poisoned.
   *
   * @return true if the character is poisoned, false otherwise.
   */
  def isPoisoned: Boolean = poisonTurnsLeft > 0

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
    burnedTurnsLeft = math.max(turns, 0)
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
  def setBurnDamage(damage: Int): Unit = {
    burnDamage = damage
  }

  /**
   * Checks if the character is currently burned.
   *
   * @return true if the character is burned, false otherwise.
   */
  def isBurned: Boolean = burnedTurnsLeft > 0

  /**
   * Returns the number of turns left for the paralysis effect.
   *
   * @return The number of turns left for the paralysis effect.
   */
  def getParalyzedTurnsLeft: Int = paralyzedTurnsLeft

  /**
   * Sets the number of turns left for the paralysis effect.
   *
   * @param turns The new number of turns left for the paralysis effect.
   */
  def setParalyzedTurnsLeft(turns: Int): Unit = {
    paralyzedTurnsLeft = math.max(0, turns)
  }

  /**
   * Checks if the character is currently paralyzed.
   *
   * @return true if the character is paralyzed, false otherwise.
   */
  def isParalyzed: Boolean = paralyzedTurnsLeft > 0

  /**
   * Applies the effects of burn and poison on the affected game unit.
   * This method should be called at the start of each turn during combat.
   */
  def applyEffects(): Unit = {
    if (isBurned) {
      affected.setHp(affected.getHp - burnDamage)
      setBurnedTurnsLeft(burnedTurnsLeft - 1)
    }
    if (isPoisoned) {
      affected.setHp(affected.getHp - poisonDamage)
      setPoisonTurnsLeft(poisonTurnsLeft - 1)
    }
    // Paralysis effect handling should be done by the turn scheduler or elsewhere.
  }
}

