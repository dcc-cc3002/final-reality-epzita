package character

import armory.Weapon
abstract class MagicCharacter extends Character {
  val name: String
  var hp: Int
  var defense: Int
  val weight: Int
  var mp: Int

  def equipWeapon(w: Weapon): Unit

}
