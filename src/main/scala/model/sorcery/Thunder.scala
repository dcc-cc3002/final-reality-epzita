package model.sorcery

import model.character.{Character, GameUnit}
import model.character.specializations.BlackMage

class Thunder (override val manaCost: Int = 20) extends DarkSpell {

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
