package model.state

/**
 * Class representing the pre-game state.
 *
 * @param context The game controller managing the game state.
 */
class PreGame(context: GameController) extends GameState(context) {
  // Set the inPreGame flag to true upon initialization
  inPreGame = true

  /**
   * Method to start the game, transitioning to the in-game state.
   */
  def startGame(): Unit = {
    // Update the game state in the context
    context.state = new InGame(context)
  }
}

