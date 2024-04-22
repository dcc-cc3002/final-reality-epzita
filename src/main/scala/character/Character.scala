package character

import armory.Weapon

/**
 * defines a the Character type which provides a base structure
 * for the rest of specializations, for example, a Warrior must be a
 * Character
 */
abstract class Character extends Person {
  val name: String
  var hp: Int
  var defense: Int
  val weight: Int

  var maxActionBar = 0
  var actionBar = 0

  def equipWeapon(): Unit

  def unequipWeapon(): Unit
}


