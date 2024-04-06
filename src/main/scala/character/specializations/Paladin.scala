package character.specializations

import armory.Weapon
import character.Character

class Paladin (val name: String,
               var hp: Int,
               var defense: Int,
               val weight: Int) extends Character{
  override def equipWeapon(w: Weapon): Unit = {
    w.owner = this
  }

}