package model.armory

import model.character.ACharacter

/**
 * abstract class that helps create only physical type weapons
 */
abstract class PhysicalWeapon extends Weapon{
  val name: String
  var damage: Int
  val defense: Int
  val weight: Int

  def sharp(): Unit

}
