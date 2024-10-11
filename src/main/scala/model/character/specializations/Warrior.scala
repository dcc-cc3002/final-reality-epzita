package model.character.specializations

import model.armory.{PhysicalWeapon, Weapon}
import model.character.{ACharacter, APhysicalCharacter}

/**
 * Class representing a Warrior character in a role-playing game.
 *
 * @param name Name of the character.
 * @param hp Health points of the character.
 * @param defense Defense capability of the character.
 * @param weight Weight of the character, affecting turn position during combat.
 */
class Warrior(val name: String,
              protected var hp: Int,
              protected var defense: Int,
              val weight: Int) extends APhysicalCharacter {

  /**
   * Equips the given weapon to the Warrior character.
   *
   * If the Warrior character already has a weapon equipped, it is unequipped before equipping the new weapon.
   *
   * @param weapon The weapon to equip.
   */
  def equipWeapon(weapon: Weapon): Unit = {
    if (this.weapon.isEmpty) {
      this.weapon = Some(weapon)
      weapon.setOwner(this) // Sets this Warrior as the owner of the weapon
      this.setMaxActionBar() // Updates the maximum action bar considering the equipped weapon
    }
  }
}
