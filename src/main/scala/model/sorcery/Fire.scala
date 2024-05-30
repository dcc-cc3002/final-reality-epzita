package model.sorcery

import model.character.GameUnit
import model.character.specializations.BlackMage

class Fire (override val manaCost: Int = 15) extends DarkSpell{

  def castSpell(caster: BlackMage, target: GameUnit): Unit = {
    if(caster.weapon.isDefined){
      if (caster.getMp >= this.manaCost) {
        caster.setMp(caster.getMp - this.manaCost)
        target.setHp(target.getHp - caster.weapon.get.getMagicDamage)
      }
      else{
        throw new Exception("This character doesn't have enough mana to cast this spell")
      }
    }
    else {
      throw new Exception("This character must first equip a Weapon")
    }
  }

}
