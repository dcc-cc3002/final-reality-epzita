package model.sorcery

import model.character.{GameUnit, MagicCharacter}

/**
 * Abstract class representing a DarkSpell in a role-playing game.
 *
 * Dark spells are a type of spell that can be cast by characters who have the ability to cast dark magic.
 */
abstract class DarkSpell extends Spell {

  /** The mana cost required to cast this spell. */
  val manaCost: Int

  /**
   * Determines if the spell can be cast by the specified caster.
   *
   * Dark spells can only be cast by characters who have the ability to cast dark spells.
   *
   * @param caster The character attempting to cast the spell.
   * @return True if the caster can cast dark spells, false otherwise.
   */
  def canBeCastBy(caster: MagicCharacter): Boolean = {
    caster.canCastDarkSpell
  }

  /**
   * Checks if the target is dead.
   *
   * This method determines if the target unit's hit points (HP) are zero, indicating that the target is dead.
   *
   * @param target The target unit to check.
   * @return True if the target is dead, false otherwise.
   */
  override def isTargetDead(target: GameUnit): Boolean = target.getHp == 0

}


