package model.sorcery

import model.character.{GameUnit, MagicCharacter}
import model.character.specializations.{BlackMage, WhiteMage}

/**
 * Abstract class representing a light spell in a role-playing game.
 *
 * Light spells are a type of spell that typically provide beneficial effects or healing.
 *
 * @param manaCost The mana cost required to cast this spell.
 */
abstract class LightSpell extends Spell {

  /** The mana cost required to cast this spell. */
  val manaCost: Int

  /**
   * Checks if the specified caster can cast light spells.
   *
   * @param caster The magic character attempting to cast the spell.
   * @return true if the caster can cast light spells, false otherwise.
   */
  def canBeCastBy(caster: MagicCharacter): Boolean = {
    caster.canCastLightSpell
  }

  /**
   * Checks if the target is dead.
   *
   * @param target The target unit to check.
   * @return true if the target's HP is 0, false otherwise.
   */
  override def isTargetDead(target: GameUnit): Boolean = target.getHp == 0

}

