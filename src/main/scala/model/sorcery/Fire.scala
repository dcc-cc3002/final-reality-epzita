package model.sorcery
import exceptions.{DeadUnitException, InvalidTargetException, InvalidWeaponException, WeaponNotFoundException}
import model.character.{Character, Enemy, GameUnit}

import scala.util.Random


/**
 * Class representing the Fire spell in a role-playing game.
 *
 * The Fire spell is a type of dark spell that inflicts damage and has a chance to burn the target.
 *
 * @param manaCost The mana cost required to cast this spell. The default value is 15.
 */
class Fire (override val manaCost: Int = 15) extends DarkSpell with DamageSpell {

  /**
   * Casts the Fire spell on the specified target.
   *
   * This method checks various conditions to ensure the spell can be cast. If the conditions are met,
   * it inflicts magic damage on the target. Additionally, there is a 20% chance to apply a burn effect
   * that lasts for 3 turns and inflicts burn damage equal to half of the magic damage.
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
        val damage = caster.getWeapon.get.getMagicDamage
        target.setHp(target.getHp - damage)
        val probability = Random.between(1, 101)
        if (probability >= 80) {
          target.getEffectHandler.setBurnedTurnsLeft(3)
          target.getEffectHandler.setBurnDamage(damage / 2)
        }
      } else {
        throw new InvalidWeaponException("A Mage needs to equip a Magic Weapon to cast a spell")
      }
    } else {
      throw new WeaponNotFoundException("The caster needs to have a Weapon equipped to cast this spell")
    }
  }

}


