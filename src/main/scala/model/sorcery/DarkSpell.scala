package model.sorcery

import model.character.GameUnit
import model.character.specializations.BlackMage

abstract class DarkSpell extends Spell {

  val caster: BlackMage
  val manaCost: Int

  def castSpell(caster: BlackMage, target: GameUnit): Unit
}
