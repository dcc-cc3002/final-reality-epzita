package model.sorcery

import model.character.{GameUnit, MagicCharacter, Character}
import model.character.specializations.{BlackMage, WhiteMage}

trait DarkSpell extends Spell {

  val manaCost: Int
  override def canBeCastBy(caster: MagicCharacter): Boolean = {
    caster.canCastDarkSpell
  }

  override def isTargetDead(target: GameUnit): Boolean = target.getHp == 0

}

