package model.sorcery
import exceptions.InvalidTargetException
import model.character.{Character, Enemy, GameUnit}

trait BuffSpell extends Spell{

  def canBeCastedUpon(target: GameUnit): Boolean = {
    target.isHealeable
  }

}
