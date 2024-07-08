package model.state

/**
 * Class representing the in-game state.
 *
 * @param context The game controller managing the game state.
 */
class InGame(context: GameController) extends GameState(context) {
  // Set the inGame flag to true upon initialization
  inGame = true
}

