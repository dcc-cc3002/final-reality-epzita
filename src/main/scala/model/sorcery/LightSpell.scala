package model.sorcery

import model.character.GameUnit
import model.character.specializations.WhiteMage

abstract class LightSpell extends Spell {

  val manaCost: Int
  def castSpell(caster: WhiteMage, target: GameUnit): Unit
}
