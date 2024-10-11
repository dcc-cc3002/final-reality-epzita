package model.sorcery

import exceptions.InvalidTargetException
import model.character.{Character, Enemy, GameUnit}

/**
 * Trait representing a DamageSpell in a role-playing game.
 *
 * Damage spells are spells that can be cast on targets to inflict damage.
 */
trait DamageSpell extends Spell {

  /**
   * Determines if the spell can be cast upon the specified target.
   *
   * Damage spells can only be cast on units that are damageable. This method checks if the target is damageable.
   *
   * @param target The target unit to check.
   * @return True if the target can be damaged, false otherwise.
   */
  def canBeCastedUpon(target: GameUnit): Boolean = {
    target.isDamageable
  }

}

