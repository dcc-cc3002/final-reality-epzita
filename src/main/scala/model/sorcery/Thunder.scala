package model.sorcery

import exceptions.{DeadUnitException, InvalidTargetException, InvalidWeaponException, WeaponNotFoundException}
import model.character.{Character, Enemy, GameUnit}
import model.character.specializations.BlackMage

import scala.util.Random

/**
 * Class representing a Thunder spell in a role-playing game.
 *
 * Thunder spells are dark spells that can inflict damage and potentially paralyze the target.
 *
 * @param manaCost The mana cost required to cast the Thunder spell.
 */
class Thunder(override val manaCost: Int = 20) extends DarkSpell with DamageSpell {

  /**
   * Casts the Thunder spell on the specified target.
   *
   * @param caster The character casting the spell.
   * @param target The target unit to be affected by the spell.
   * @throws InvalidTargetException If the spell cannot be cast on an ally.
   * @throws DeadUnitException If the target unit is already dead.
   * @throws InvalidWeaponException If the caster does not have a suitable weapon equipped.
   * @throws WeaponNotFoundException If the caster has no weapon equipped.
   */
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
          target.getEffectHandler.setParalyzedTurnsLeft(1)
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

