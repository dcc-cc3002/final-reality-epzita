package model.sorcery

import exceptions.DeadUnitException
import model.character.{Character, GameUnit}
import model.character.specializations.WhiteMage

class Heal(override val manaCost: Int = 15) extends LightSpell {
  override def cast(caster: Character, target: GameUnit): Unit = {
    if (isTargetDead(target)) {
      throw new DeadUnitException("This Unit is already dead")
    }
    val heal_amount = (target.getHp*0.3).toInt
    target.setHp(target.getHp + heal_amount)
  }

}
