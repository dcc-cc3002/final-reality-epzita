package model.armory

import model.character.Person

/**
 * weapon interface, helps create different kinds of weapon classes and eventually
 * every weapon
 */
trait Weapon {
  val name: String
  var damage: Int
  val defense: Int
  val weight: Int

  def setOwner(character: Option[Person]): Unit
  def leaveOwner(): Unit
}
