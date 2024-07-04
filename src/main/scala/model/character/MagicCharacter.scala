package model.character

import model.sorcery.Spell

trait MagicCharacter {

  var mp: Int
  val maxMp: Int

  def canCastDarkSpell: Boolean
  def canCastLightSpell: Boolean

  def castSpell(spell: Spell, target: GameUnit): Unit

}
