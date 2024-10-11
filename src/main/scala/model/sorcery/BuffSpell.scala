package model.sorcery
import exceptions.InvalidTargetException
import model.character.{Character, Enemy, GameUnit}

/**
 * Trait representing a BuffSpell in a role-playing game.
 *
 * Buff spells are spells that can be cast on targets to provide beneficial effects, such as healing or enhancing attributes.
 */
trait BuffSpell extends Spell {

  /**
   * Determines if the spell can be cast upon the specified target.
   *
   * Buff spells can only be cast on units that are healable. This method checks if the target is healable.
   *
   * @param target The target unit to check.
   * @return True if the target can be healed, false otherwise.
   */
  def canBeCastedUpon(target: GameUnit): Boolean = {
    target.isHealeable
  }

}

