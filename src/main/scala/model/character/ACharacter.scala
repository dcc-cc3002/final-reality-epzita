package model.character

import model.armory.Weapon

/**
 * defines a the Character type which provides a base structure
 * for the rest of specializations, for example, a Warrior must be a
 * Character
 */
abstract class ACharacter extends Person {
  /** character's stats */
  val name: String
  var hp: Int
  var defense: Int
  val weight: Int

  var weapon: Weapon = _

  var maxActionBar = 0
  var actionBar = 0

  /**
   * variable switch that helps to determine if theres a weapon equipped or not
   */

  def equipWeapon(weapon: Weapon): Unit = {
    if (this.weapon == null) {
      this.weapon = weapon

    }
  }

  def unequipWeapon(weapon: Weapon): Unit = {
    this.weapon = null

  }

  var hasweapon = false

  /**
   * Equips a weapon triggering the hasweapon switch
   */
  def equipWeapon(): Unit = {
    hasweapon = true

  }

  /**
   * unequips a weapon triggering the hasweapon switch
   */
  def unequipWeapon(): Unit = {
    hasweapon = false
  }

  /**
   * @return boolean indicating if there is in fact a weapon equipped or not
   */
  def hasWeapon: Boolean = {
    hasweapon
  }
}


