package model.sorcery

import model.character.{Character, GameUnit}
import model.character.specializations.WhiteMage

class Paralize(override val manaCost: Int = 25) extends LightSpell {
  override def cast(caster: Character, target: GameUnit): Unit = {
    if (caster.weapon.isDefined) {
      val damage = caster.weapon.get.getMagicDamage
      target.setHp(target.getHp - damage)
    }
    else {
      throw new Exception("The caster needs to have a Weapon equipped to cast this spell")
    }

  }

}
