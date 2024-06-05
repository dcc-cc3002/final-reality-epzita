package model.sorcery

import exceptions.{DeadUnitException, InvalidTargetException}
import model.character.{Character, Enemy, GameUnit}
import model.character.specializations.WhiteMage

class Heal(override val manaCost: Int = 15) extends LightSpell with BuffSpell {

  def cast(caster: Character, target: GameUnit): Unit = {
    if (!this.canBeCastedUpon(target)) {
      throw new InvalidTargetException("This spell cannot be casted upon an ally")
    }
    if (isTargetDead(target)) {
      throw new DeadUnitException("This Unit is already dead")
    }
    val heal_amount = (target.getHp*0.3).toInt
    target.setHp(target.getHp + heal_amount)
  }

}
