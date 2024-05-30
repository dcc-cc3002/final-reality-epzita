package model.sorcery

import model.character.{GameUnit, MagicCharacter,Character}
import model.character.specializations.{BlackMage, WhiteMage}

trait Spell {

  val manaCost: Int
  def canBeCastBy(caster: MagicCharacter): Boolean
  def cast(caster: Character, target: GameUnit): Unit



}
