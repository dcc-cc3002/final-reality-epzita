package model.effects

import model.character.{Enemy, GameUnit}

class EffectHandler(affected: GameUnit) {
  private var poisonTurnsLeft: Int = 0
  private var burnedTurnsLeft: Int = 0
  private var paralizedTurnsLeft: Int = 0
  def getPoisonTurnsLeft: Int = poisonTurnsLeft
  def setPoisonTurnsLeft(turns: Int): Unit = {
    poisonTurnsLeft = turns
  }

  def getBurnedTurnsLeft: Int = burnedTurnsLeft
  def setBurnedTurnsLeft(turns: Int): Unit = {
    burnedTurnsLeft = turns
  }
  def getParalizedTurnsLeft: Int = paralizedTurnsLeft
  def setParalizedTurnsLeft(turns: Int): Unit = {
    poisonTurnsLeft = turns
  }



}
