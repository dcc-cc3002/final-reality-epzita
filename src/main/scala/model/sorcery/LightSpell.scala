package model.sorcery

import model.character.{GameUnit, MagicCharacter}
import model.character.specializations.{BlackMage, WhiteMage}

abstract class LightSpell extends Spell {


  val manaCost: Int
  def canBeCastBy(caster: MagicCharacter): Boolean = {
    caster.canCastLightSpell
  }
  override def isTargetDead(target: GameUnit): Boolean = target.getHp == 0
}
