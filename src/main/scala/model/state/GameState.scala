package model.state

class GameState(val context: GameController){
  var inPreGame:    Boolean = false
  var inGame:       Boolean = false
  var inCombat: Boolean = false
  var inEndGame:    Boolean = false

  def error(): Unit = throw new Exception("This action cannot be triggered in this state")
  def setState(state: GameState): Unit = context.state = state

}
