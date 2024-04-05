package armory

import character.MagicCharacter

abstract class MagicWeapon extends Weapon {
  val name: String
  val damage: Int
  val magicDamage: Int
  val defense: Int
  val weight: Int
  var owner: MagicCharacter
}
