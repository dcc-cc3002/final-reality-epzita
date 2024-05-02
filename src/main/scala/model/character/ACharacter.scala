package model.character

import model.armory.Weapon

/**
 * defines a the Character type which provides a base structure
 * for the rest of specializations, for example, a Warrior must be a
 * Character
 */
abstract class ACharacter extends Character {
  /** character's stats */
  val name: String
  var hp: Int
  var defense: Int
  val weight: Int

  var weapon: Option[Weapon] = None

  var maxActionBar: Int = weight
  var actionBar = 0


  /**
   * variable switch that helps to determine if theres a weapon equipped or not
   */

  def equipWeapon(weapon: Weapon): Unit = {
    if (this.weapon.isEmpty) {
      this.weapon = Some(weapon)
      weapon.setOwner(this)
      maxActionBar += weapon.weight
    }
  }

  def unequipWeapon(): Unit = {
    this.weapon = None
  }

  /**
   * @return boolean indicating if there is in fact a weapon equipped or not
   */
  def hasWeapon: Boolean = {
     this.weapon.isDefined
  }
}


