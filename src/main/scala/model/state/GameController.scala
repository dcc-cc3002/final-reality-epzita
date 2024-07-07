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
  val enemy_party = new ArrayBuffer[Enemy]
  val party = new Party()

  def startGame(players: ArrayBuffer[Character], enemies: ArrayBuffer[Enemy]): Unit = {
     for(player<-players){
       party.addMember(player)
     }
     gameCharacters++= players
     gameCharacters++= enemies
     enemy_party ++= enemies
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
    if(turnScheduler.fightList.length >= index + 1){
      val turnCharacter = turnScheduler.fightList(index + 1)
      turnScheduler.setTurnCharacter(index+1)
    }

  }
  def playerEquipWeapon(player: Character, weapon: Weapon): Unit = player.equipWeapon(weapon)

  def isEnemyDefeated: Boolean ={
    var total_hp = 0
    for(enemy <- enemy_party){
      total_hp += enemy.getHp
    }
    total_hp == 0
  }

  def win: Boolean = isEnemyDefeated

  def lose: Boolean = party.isDefeated

  def endGame(): Unit ={
    if(win){
      state = new EndGame(this)
      println("Heroes have won!")
    }
    if(lose){
      state = new EndGame(this)
      println("Heroes have been defeated!...")
    }
  }

}



