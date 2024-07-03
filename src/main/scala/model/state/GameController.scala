package model.state

import model.character.{Character, Enemy, GameUnit}
import model.party.Party

import scala.collection.mutable.ArrayBuffer


class GameController {
  var state: GameState = new PreGame(this)
   private val gameCharacters = ArrayBuffer[GameUnit]
  def startGame(players: ArrayBuffer[Character], enemies: ArrayBuffer[Enemy]): Unit = {
     val party = new Party()
     for(player<-players){
       party.addMember(player)
     }
    gameCharacters.appendAll(players)
    gameCharacters ++= enemies

  }
}
