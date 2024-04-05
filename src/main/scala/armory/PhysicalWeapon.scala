package armory

import character.Character

abstract class PhysicalWeapon extends Weapon{
  val name: String
  val damage: Int
  val defense: Int
  val weight: Int
  var owner: Character

  def getOwner(w:Weapon): Character = {
    w.owner
  }

  def setOwner(c: Character): Unit = {
    this.owner = c
  }

}
