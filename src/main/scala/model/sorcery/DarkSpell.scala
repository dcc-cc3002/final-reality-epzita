package model.sorcery

import model.character.{GameUnit, MagicCharacter}

abstract class DarkSpell extends Spell {

  val manaCost: Int
  def canBeCastBy(caster: MagicCharacter): Boolean = {
    caster.canCastDarkSpell
  }
  override def isTargetDead(target: GameUnit): Boolean = target.getHp == 0

}

