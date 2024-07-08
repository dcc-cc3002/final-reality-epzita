package model.state

import model.armory.Weapon
import model.character.{Character, Enemy, GameUnit, MagicCharacter}
import model.party.Party
import model.sorcery.Spell
import model.turnscheduler.TurnScheduler

import scala.collection.mutable.ArrayBuffer


import scala.collection.mutable.ArrayBuffer

/**
 * Class handling the main logic and flow of the game.
 *
 * This class manages the game state, characters, turn scheduling, and various game actions such as attacks and spell casting.
 */
class GameController {
  /** The current state of the game. Starts as PreGame. */
  var state: GameState = new PreGame(this)
  /** A collection of all game units participating in the game. */
  private val gameCharacters = new ArrayBuffer[GameUnit]
  /** Scheduler managing the turn order of characters. */
  val turnScheduler = new TurnScheduler
  /** A collection of all enemy units in the game. */
  private val enemy_party = new ArrayBuffer[Enemy]
  /** The player's party. */
  val party = new Party()

  /**
   * Starts the game with the given players and enemies.
   *
   * Initializes the player's party and adds all characters to the game state and turn scheduler.
   *
   * @param players A collection of player characters.
   * @param enemies A collection of enemy characters.
   */
  def startGame(players: ArrayBuffer[Character], enemies: ArrayBuffer[Enemy]): Unit = {
    for (player <- players) {
      party.addMember(player)
    }
    gameCharacters ++= players
    gameCharacters ++= enemies
    enemy_party ++= enemies
    for (character <- gameCharacters) {
      turnScheduler.addNewCharacter(character)
    }
    // Game state is set to InGame
    state = new InGame(this)
  }

  /**
   * Executes an attack from the attacker to the target.
   *
   * Ensures that it is the attacker's turn before allowing the attack.
   *
   * @param attacker The unit performing the attack.
   * @param target The unit being attacked.
   * @throws Exception if it is not the attacker's turn.
   */
  def unitAttack(attacker: GameUnit, target: GameUnit): Unit = {
    if (turnScheduler.turnCharacter == attacker) {
      attacker.attack(target)
    } else {
      throw new Exception("This isn't this unit's turn")
    }
  }

  /**
   * Executes a spell cast from a mage to a target enemy.
   *
   * Ensures that it is the mage's turn before allowing the spell cast.
   *
   * @param spell The spell being cast.
   * @param caster The mage casting the spell.
   * @param target The enemy target of the spell.
   * @throws Exception if it is not the mage's turn.
   */
  def mageCast(spell: Spell, caster: MagicCharacter, target: Enemy): Unit = {
    if (turnScheduler.turnCharacter == caster) {
      caster.castSpell(spell, target)
    } else {
      throw new Exception("This isn't this unit's turn")
    }
  }

  /**
   * Passes the turn to the next character in the turn order.
   *
   * @param turnUnit The unit whose turn is being passed.
   */
  def passTurn(turnUnit: GameUnit): Unit = {
    val index = turnScheduler.fightList.indexOf(turnUnit)
    if (turnScheduler.fightList.length >= index + 1) {
      turnScheduler.setTurnCharacter(index + 1)
    }
  }

  /**
   * Equips a weapon to a player character.
   *
   * @param player The player character equipping the weapon.
   * @param weapon The weapon to be equipped.
   */
  def playerEquipWeapon(player: Character, weapon: Weapon): Unit = player.equipWeapon(weapon)

  /**
   * Checks if all enemies have been defeated.
   *
   * @return true if all enemies are defeated, false otherwise.
   */
  private def isEnemyDefeated: Boolean = {
    var total_hp = 0
    for (enemy <- enemy_party) {
      total_hp += enemy.getHp
    }
    total_hp == 0
  }

  /**
   * Checks if the player has won the game.
   *
   * @return true if all enemies are defeated, false otherwise.
   */
  private def win: Boolean = isEnemyDefeated

  /**
   * Checks if the player has lost the game.
   *
   * @return true if the player's party is defeated, false otherwise.
   */
  private def lose: Boolean = party.isDefeated

  /**
   * Ends the game, setting the game state to EndGame and printing the result.
   */
  def endGame(): Unit = {
    if (win) {
      state = new EndGame(this)
      println("Heroes have won!")
    } else if (lose) {
      state = new EndGame(this)
      println("Heroes have been defeated!...")
    }
  }
}




