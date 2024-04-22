package character

import armory.{MagicWeapon, Weapon}

/**
 * Abstracts class which extends from Character, built to have a better
 * design when it comes to implementing Mage characters
 * Adds the mp (mana points) attribute
 */
abstract class MagicCharacter extends Person {
  val name: String
  var hp: Int
  var defense: Int
  val weight: Int
  var mp: Int

  var maxActionBar = 0
  var actionBar = 0

  def equipWeapon(): Unit

  def unequipWeapon(): Unit

}
