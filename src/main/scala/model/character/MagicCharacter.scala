package model.character

import model.sorcery.Spell

/**
 * Trait representing a magic character in the game.
 *
 * This trait defines properties and behaviors specific to characters capable of casting spells.
 */
trait MagicCharacter {

  /** The current mana points of the magic character. */
  var mp: Int

  /** The maximum mana points of the magic character. */
  val maxMp: Int

  /**
   * Indicates if the magic character can cast dark spells.
   *
   * @return true if the magic character can cast dark spells, false otherwise.
   */
  def canCastDarkSpell: Boolean

  /**
   * Indicates if the magic character can cast light spells.
   *
   * @return true if the magic character can cast light spells, false otherwise.
   */
  def canCastLightSpell: Boolean

  /**
   * Casts the specified spell on the target game unit.
   *
   * @param spell The spell to cast.
   * @param target The target game unit on which to cast the spell.
   */
  def castSpell(spell: Spell, target: GameUnit): Unit

}

