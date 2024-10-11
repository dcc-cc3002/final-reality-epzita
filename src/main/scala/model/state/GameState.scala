package model.state

/**
 * Class representing the state of the game.
 *
 * @param context The game controller managing the game state.
 */
class GameState(val context: GameController) {
  var inPreGame: Boolean = false   // Indicates if the game is in the pre-game phase.
  var inGame: Boolean = false      // Indicates if the game is currently running.
  var inCombat: Boolean = false    // Indicates if the game is in combat mode.
  var inEndGame: Boolean = false   // Indicates if the game has ended.

}

