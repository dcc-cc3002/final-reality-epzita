package model.sorcery
import model.character.Character
import model.character.GameUnit


class Fire (override val manaCost: Int = 15) extends DarkSpell {

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

