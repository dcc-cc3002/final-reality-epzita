package armory

import character.Character

trait MagicWeapon extends Weapon {
  val name: String
  val damage: Int
  val magicDamage: Int
  val defense: Int
  val weight: Int
  val owner: Character
}
