package character.specializations

import armory.Weapon
import character.MagicCharacter

class BlackMage(val name: String,
                var hp: Int,
                var defense: Int,
                val weight: Int,
                var mp: Int) extends MagicCharacter{
  override def equipWeapon(w: Weapon): Unit = {
    w.owner = this
  }
}
