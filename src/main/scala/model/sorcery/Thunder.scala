package model.sorcery

import exceptions.{DeadUnitException, InvalidTargetException, InvalidWeaponException, WeaponNotFoundException}
import model.character.{Character, Enemy, GameUnit}
import model.character.specializations.BlackMage

import scala.util.Random

class Thunder (override val manaCost: Int = 20) extends DarkSpell with DamageSpell{

  def cast(caster: Character, target: GameUnit): Unit = {
    if (!this.canBeCastedUpon(target)) {
      throw new InvalidTargetException("This spell cannot be casted upon an ally")
    }
    if (isTargetDead(target)) {
      throw new DeadUnitException("This Unit is already dead")
    }
    if (caster.hasWeapon) {
      if (caster.getWeapon.get.hasMagicDamage) {
        val damage = caster.getWeapon.get.getMagicDamage
        target.setHp(target.getHp - damage)
        val probability = Random.between(1, 101)
        if (probability >= 80) {
          target.getEffectHandler.setParalizedTurnsLeft(1)
        }
      }
      else {
        throw new InvalidWeaponException("A Mage needs a to equip Magic Weapon to cast a spell")
      }
    }
    else {
      throw new WeaponNotFoundException("The caster needs to have a Weapon equipped to cast this spell")
    }
  }

}
