package character

import armory.{MagicWeapon, Weapon}

/**
 * Abstracts class which extends from Character, built to have a better
 * design when it comes to implementing Mage characters
 * Adds the mp (mana points) attribute
 */
abstract class MagicCharacter extends Character {
  val name: String
  var hp: Int
  var defense: Int
  val weight: Int
  var mp: Int

  def equipWeapon(): Unit

  def unequipWeapon(): Unit

}
