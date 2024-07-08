package model.sorcery

import exceptions.{DeadUnitException, InvalidTargetException, InvalidWeaponException, WeaponNotFoundException}
import model.character.{Character, Enemy, GameUnit}
import model.character.specializations.WhiteMage

/**
 * Class representing the Paralize spell, which is a type of LightSpell and DamageSpell.
 *
 * This spell can be cast by a character to paralyze a target for a certain number of turns.
 *
 * @param manaCost The mana cost required to cast this spell. Defaults to 25.
 */
class Paralize(override val manaCost: Int = 25) extends LightSpell with DamageSpell {

  /**
   * Casts the Paralize spell on the target.
   *
   * This method checks several conditions before applying the paralyze effect:
   * - The spell can only be cast on enemies, not allies.
   * - The target must be alive.
   * - The caster must have a weapon equipped that deals magic damage.
   *
   * @param caster The character casting the spell.
   * @param target The target unit to be paralyzed.
   * @throws InvalidTargetException If the spell is cast on an invalid target.
   * @throws DeadUnitException If the target is already dead.
   * @throws InvalidWeaponException If the caster's weapon does not deal magic damage.
   * @throws WeaponNotFoundException If the caster does not have a weapon equipped.
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
        target.getEffectHandler.setParalyzedTurnsLeft(1)
      } else {
        throw new InvalidWeaponException("A Mage needs to equip a Magic Weapon to cast a spell")
      }
    } else {
      throw new WeaponNotFoundException("The caster needs to have a Weapon equipped to cast this spell")
    }
  }

}

