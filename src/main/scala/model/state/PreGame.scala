package model.state

class PreGame(context: GameController) extends GameState(context){
  this.inPreGame = true
  def startGame: Unit = this.context.state = new InGame(context)

}
