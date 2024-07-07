package model.state

import model.armory.Weapon
import model.character.{Character, Enemy, GameUnit, MagicCharacter}
import model.party.Party
import model.sorcery.Spell
import model.turnscheduler.TurnScheduler

import scala.collection.mutable.ArrayBuffer


class GameController {
  //game state starts as Pre Game
  var state: GameState = new PreGame(this)
  val gameCharacters = new ArrayBuffer[GameUnit]
  val turnScheduler = new TurnScheduler
  val enemies = new ArrayBuffer[Enemy]
  val party = new Party()

  def startGame(players: ArrayBuffer[Character], enemies: ArrayBuffer[Enemy]): Unit = {
     for(player<-players){
       party.addMember(player)
     }

  gameCharacters++= players
     gameCharacters++= enemies
     for(character <- gameCharacters){
       turnScheduler.addNewCharacter(character)
     }
     //game state is set to In Game
     state = new InGame(this)
  }
  def unitAttack(attacker: GameUnit, target: GameUnit): Unit = {
    if(turnScheduler.turnCharacter == attacker){
      attacker.attack(target)
    }
    else{
      throw new Exception("This isn't this unit's turn")
    }
  }
  def mageCast(spell: Spell, caster: MagicCharacter, target: Enemy) = {
    if(turnScheduler.turnCharacter == caster){
      caster.castSpell(spell, target)
    }
    else{
      throw new Exception("This isn't this unit's turn")
    }
  }

  def passTurn(turnUnit: GameUnit): Unit = {
    val index = turnScheduler.fightList.indexOf(turnUnit)
    val turnCharacter = turnScheduler.fightList[]
    turnScheduler.setTurnCharacter()
  }
  def playerEquipWeapon(player: Character, weapon: Weapon) = player.equipWeapon(weapon)

  def win: Boolean = enemies.length == 0

  def lose: Boolean = party.isDefeated

}



