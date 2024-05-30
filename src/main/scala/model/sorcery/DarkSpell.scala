package model.sorcery

import model.character.{GameUnit, MagicCharacter, Character}
import model.character.specializations.{BlackMage, WhiteMage}

trait DarkSpell extends Spell {

  val manaCost: Int

  override def cast(caster: Character, target: GameUnit): Unit
  override def canBeCastBy(caster: MagicCharacter): Boolean = {
    caster.canCastDarkSpell
  }

}

