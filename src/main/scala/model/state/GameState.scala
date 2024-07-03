package model.state

class GameState(val context: GameController) extends GameState(context){
    var inPreGame:    Boolean = false
    var inGame:       Boolean = false
    var inPlayerTurn: Boolean = false
    var inEndGame:    Boolean = false

  def setState(state: GameState): Unit = context.state = state

}
