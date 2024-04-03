package armory

import character.Character

trait Weapon {
  //puede cambiar el ataque?
  val name: String
  val damage: Int
  val defense: Int
  val weight: Int
  val owner: Character

}
