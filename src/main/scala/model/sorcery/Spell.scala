package model.sorcery

import model.character.{Character, Enemy, GameUnit, MagicCharacter}
import model.character.specializations.{BlackMage, WhiteMage}

trait Spell {

  val manaCost: Int
  def canBeCastBy(caster: MagicCharacter): Boolean

  def isTargetDead(target: GameUnit): Boolean
  def cast(caster: Character, target: GameUnit): Unit



}
