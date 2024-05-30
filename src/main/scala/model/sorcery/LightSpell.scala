package model.sorcery

import model.character.{GameUnit, MagicCharacter}
import model.character.specializations.{BlackMage, WhiteMage}

trait LightSpell extends Spell {

  val manaCost: Int

  override def canBeCastBy(caster: MagicCharacter): Boolean = {
    caster.canCastLightSpell
  }
}
