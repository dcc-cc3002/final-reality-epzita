package model.state

/**
 * Class representing the end game state of the game.
 *
 * @param context The game controller managing the game state.
 */
class EndGame(context: GameController) extends GameState(context) {
  // Set the inEndGame flag to true upon initialization
  inEndGame = true
}

