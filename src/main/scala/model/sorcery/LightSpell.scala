package model.sorcery

import model.character.GameUnit
import model.character.specializations.WhiteMage

abstract class LightSpell extends Spell {

  val caster: WhiteMage
  val manaCost: Int
  def castSpell(this.caster, target: GameUnit): Unit
}
