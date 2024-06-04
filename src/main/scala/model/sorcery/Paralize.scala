package model.sorcery

import exceptions.{DeadUnitException, WeaponNotFoundException}
import model.character.{Character, GameUnit}
import model.character.specializations.WhiteMage

class Paralize(override val manaCost: Int = 25) extends LightSpell {
  override def cast(caster: Character, target: GameUnit): Unit = {
    if (isTargetDead(target)) {
      throw new DeadUnitException("This Unit is already dead")
    }
    if (caster.hasWeapon) {
      val damage = caster.getWeapon.get.getMagicDamage
      target.setHp(target.getHp - damage)
    }
    else {
      throw new WeaponNotFoundException("The caster needs to have a Weapon equipped to cast this spell")
    }

  }

}
