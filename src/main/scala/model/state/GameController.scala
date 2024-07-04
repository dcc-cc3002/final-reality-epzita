package model.state

import model.armory.Weapon
import model.character.{Character, Enemy, GameUnit, MagicCharacter}
import model.party.Party
import model.sorcery.Spell

import scala.collection.mutable.ArrayBuffer


class GameController {
  //game state starts as Pre Game
  var state: GameState = new PreGame(this)
  val gameCharacters = new ArrayBuffer[GameUnit]

  def startGame(players: ArrayBuffer[Character], enemies: ArrayBuffer[Enemy]): Unit = {
     val party = new Party()
     for(player<-players){
       party.addMember(player)
     }
     gameCharacters++= players
     gameCharacters++= enemies
     //game state is set to In Game
     state = new InGame(this)
  }
  def unitAttack(attacker: GameUnit, target: GameUnit): Unit = attacker.attack(target)
  def mageCast(spell: Spell, caster: MagicCharacter, target: Enemy) = caster.castSpell(spell, target)
  def playerEquipWeapon(player: Character, weapon: Weapon) = player.equipWeapon(weapon)

}



