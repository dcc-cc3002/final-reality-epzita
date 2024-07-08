package model.sorcery

import model.character.{Character, Enemy, GameUnit, MagicCharacter}
import model.character.specializations.{BlackMage, WhiteMage}

/**
 * Trait representing a spell in a role-playing game.
 *
 * This trait defines the basic properties and behaviors of a spell, including its mana cost,
 * casting eligibility, and methods for checking the target's status and casting the spell.
 */
trait Spell {

  /** The mana cost required to cast the spell. */
  val manaCost: Int

  /**
   * Determines if the spell can be cast by the given caster.
   *
   * @param caster The magic character attempting to cast the spell.
   * @return true if the caster can cast the spell, false otherwise.
   */
  def canBeCastBy(caster: MagicCharacter): Boolean

  /**
   * Checks if the target unit is dead.
   *
   * @param target The target unit to check.
   * @return true if the target is dead, false otherwise.
   */
  def isTargetDead(target: GameUnit): Boolean

  /**
   * Casts the spell on the specified target.
   *
   * @param caster The character casting the spell.
   * @param target The target unit to be affected by the spell.
   */
  def cast(caster: Character, target: GameUnit): Unit

}

