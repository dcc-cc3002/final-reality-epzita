package armory

import character.{Character, MagicCharacter}

/**
 * magic weapon, extends from weapon and adds magic damage parameter
 */
abstract class MagicWeapon extends Weapon {
  val name: String
  var damage: Int
  var magicDamage: Int
  val defense: Int
  val weight: Int

  def enhance(): Unit

}
