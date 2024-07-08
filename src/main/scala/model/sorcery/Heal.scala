package model.sorcery

import exceptions.{DeadUnitException, InvalidTargetException, InvalidWeaponException, WeaponNotFoundException}
import model.character.{Character, GameUnit}

/**
 * Class representing the Heal spell in a role-playing game.
 *
 * The Heal spell is a type of light spell that restores a percentage of the target's health points (HP).
 *
 * @param manaCost The mana cost required to cast this spell. The default value is 15.
 */
class Heal(override val manaCost: Int = 15) extends LightSpell with BuffSpell {

  /**
   * Casts the Heal spell on the specified target.
   *
   * This method checks various conditions to ensure the spell can be cast. If the conditions are met,
   * it restores 30% of the target's current HP.
   *
   * @param caster The character casting the spell.
   * @param target The target unit to cast the spell on.
   * @throws InvalidTargetException If the spell cannot be cast on the target.
   * @throws DeadUnitException If the target unit is already dead.
   * @throws InvalidWeaponException If the caster does not have a magic weapon equipped.
   * @throws WeaponNotFoundException If the caster does not have any weapon equipped.
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
        val healAmount = (target.getHp * 0.3).toInt
        target.setHp(target.getHp + healAmount)
      } else {
        throw new InvalidWeaponException("A Mage needs to equip a Magic Weapon to cast a spell")
      }
    } else {
      throw new WeaponNotFoundException("The caster needs to have a Weapon equipped to cast this spell")
    }
  }

}

