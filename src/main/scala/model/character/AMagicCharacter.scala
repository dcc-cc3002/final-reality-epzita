package model.character

import model.armory.Weapon


/**
 * Abstracts class which extends from Character, built to have a better
 * design when it comes to implementing Mage characters
 * Adds the mp (mana points) attribute
 */
abstract class AMagicCharacter extends Person {
  val name: String
  var hp: Int
  var defense: Int
  val weight: Int
  var mp: Int


  var weapon: Option[Weapon] = None

  var maxActionBar: Int = weight
  var actionBar: Int = 0

  /**
   * variable switch that helps to determine if theres a weapon equipped or not
   */

  def equipWeapon(weapon: Weapon): Unit = {
    if(this.weapon.isEmpty) {
      this.weapon = Some(weapon)
      weapon.setOwner(this)
      maxActionBar += weapon.weight
    }
  }

  def unequipWeapon(weapon: Weapon): Unit = {
    this.weapon = None
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
