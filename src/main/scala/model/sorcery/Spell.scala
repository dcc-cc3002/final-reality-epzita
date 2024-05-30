package model.sorcery

import model.character.{GameUnit, MagicCharacter}
import model.character.specializations.{BlackMage, WhiteMage}

trait Spell {

  val manaCost: Int
  def canBeCastBy(caster: MagicCharacter): Boolean
  def cast(target: GameUnit): Unit



}
