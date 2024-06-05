package model.sorcery

import exceptions.InvalidTargetException
import model.character.{Character, Enemy, GameUnit}

trait DamageSpell extends Spell{
  def canBeCastedUpon(target: GameUnit): Boolean = {
    target.isDamageable
  }
}
