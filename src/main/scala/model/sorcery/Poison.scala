package model.sorcery

import exceptions.{DeadUnitException, InvalidTargetException, InvalidWeaponException, WeaponNotFoundException}
import model.character.{Character, Enemy, GameUnit}

import scala.util.Random

/**
 * Class representing a poison spell in a role-playing game.
 *
 * The Poison spell inflicts damage over time by applying a poison effect to the target.
 *
 * @param manaCost The mana cost required to cast this spell.
 */
class Poison(override val manaCost: Int = 30) extends LightSpell with DamageSpell {

  /**
   * Casts the Poison spell on the specified target.
   *
   * This method applies the poison effect to the target, dealing damage over time if the target is valid.
   *
   * @param caster The character casting the spell.
   * @param target The target unit to be poisoned.
   * @throws InvalidTargetException if the spell cannot be casted upon the target.
   * @throws DeadUnitException if the target is already dead.
   * @throws InvalidWeaponException if the caster does not have a magic weapon equipped.
   * @throws WeaponNotFoundException if the caster does not have a weapon equipped.
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
        target.getEffectHandler.setPoisonTurnsLeft(4)
        target.getEffectHandler.setPoisonDamage(damage / 3)
      } else {
        throw new InvalidWeaponException("A Mage needs a to equip Magic Weapon to cast a spell")
      }
    } else {
      throw new WeaponNotFoundException("The caster needs to have a Weapon equipped to cast this spell")
    }
  }

}

