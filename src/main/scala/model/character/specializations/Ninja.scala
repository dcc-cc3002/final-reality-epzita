package model.character.specializations

import model.armory.{PhysicalWeapon, Weapon}
import model.character.ACharacter

/**
 * Class representing a Ninja character in a role-playing game.
 *
 * @param name Name of the character.
 * @param hp Health points of the character.
 * @param defense Defense capability of the character.
 * @param weight Weight of the character, affecting turn position during combat.
 */
class Ninja(val name: String,
            protected var hp: Int,
            protected var defense: Int,
            val weight: Int) extends ACharacter {

  /**
   * Equips the given weapon to the Ninja character.
   *
   * If the Ninja character already has a weapon equipped, it is unequipped before equipping the new weapon.
   *
   * @param weapon The weapon to equip.
   */
  def equipWeapon(weapon: Weapon): Unit = {
    if (this.weapon.isEmpty) {
      this.weapon = Some(weapon)
      weapon.setOwner(this) // Sets this Ninja as the owner of the weapon
      this.setMaxActionBar() // Updates the maximum action bar considering the equipped weapon
    }
  }
}
