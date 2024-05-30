package model.character

trait MagicCharacter {

  var mp: Int
  val maxMp: Int

  def canCastDarkSpell: Boolean
  def canCastLightSpell: Boolean

}
