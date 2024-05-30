package model.sorcery

import model.character.{GameUnit, MagicCharacter}
import model.character.specializations.{BlackMage, WhiteMage}

trait DarkSpell extends Spell {

  val manaCost: Int

  def cast(target: GameUnit): Unit
  override def canBeCastBy(caster: MagicCharacter): Boolean = {
    caster.canCastDarkSpell
  }
}

