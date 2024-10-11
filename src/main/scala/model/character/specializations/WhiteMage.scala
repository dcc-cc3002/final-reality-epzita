package model.character.specializations

import model.armory.{MagicWeapon, Weapon}
import model.character.{ACharacter, AMagicCharacter}

/**
 *
 * @param name name of the character
 * @param hp  health points
 * @param defense defense capability
 * @param weight weight, determines positions during turns
 * @param mp mana points, indicates what spells the character can cast
 */

/**
 * Class representing a White Mage character in a role-playing game.
 *
 * @param name Name of the character.
 * @param hp Health points of the character.
 * @param defense Defense capability of the character.
 * @param weight Weight of the character, affecting turn position during combat.
 * @param mp Magic points of the character.
 * @param maxMp Maximum magic points of the character.
 */
class WhiteMage(val name: String,
                protected var hp: Int,
                protected var defense: Int,
                val weight: Int,
                var mp: Int,
                val maxMp: Int = 100) extends AMagicCharacter {

  /**
   * Equips the given weapon to the White Mage character.
   *
   * If the White Mage character already has a weapon equipped, it is unequipped before equipping the new weapon.
   *
   * @param weapon The weapon to equip.
   */
  def equipWeapon(weapon: Weapon): Unit = {
    if (this.weapon.isEmpty) {
      this.weapon = Some(weapon)
      weapon.setOwner(this) // Sets this White Mage as the owner of the weapon
      this.setMaxActionBar() // Updates the maximum action bar considering the equipped weapon
    }
  }

  /**
   * Indicates if the White Mage can cast dark spells.
   *
   * @return true if the White Mage can cast dark spells, false otherwise.
   */
  override def canCastDarkSpell: Boolean = false

  /**
   * Indicates if the White Mage can cast light spells.
   *
   * @return true if the White Mage can cast light spells, false otherwise.
   */
  override def canCastLightSpell: Boolean = true
}

