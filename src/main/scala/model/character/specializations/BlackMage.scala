package model.character.specializations

import model.armory.{MagicWeapon, Weapon}
import model.character.{AMagicCharacter, GameUnit}
import model.sorcery.Spell

/**
 *
 * @param name name of the character
 * @param hp  health points
 * @param defense defense capability
 * @param weight weight, determines positions during turns
 * @param mp mana points, indicates what spells the character can cast
 */
class BlackMage(val name: String,
                protected var hp: Int,
                protected var defense: Int,
                val weight: Int,
                protected var mp: Int) extends AMagicCharacter{
  def equipWeapon(weapon: Weapon): Unit = {
    if (this.weapon.isEmpty) {
      this.weapon = Some(weapon)
      weapon.setOwner(this)
      this.setMaxActionBar()
    }
  }

  override def canCastDarkSpell: Boolean = true

  override def canCastLightSpell: Boolean = false



}
