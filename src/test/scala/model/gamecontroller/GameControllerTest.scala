package model.gamecontroller

import model.armory.{Staff, Sword}
import model.character.Enemy
import model.character.specializations.{Paladin, Warrior, WhiteMage}
import model.sorcery.{Fire, Paralize, Poison}
import model.state.{EndGame, GameController, InGame, PreGame}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class GameControllerTest extends FunSuite{
  var gameController: GameController = _
  var warrior: Warrior = _
  var mage: WhiteMage = _
  var paladin: Paladin = _
  var enemy: Enemy= _
  var sword: Sword = _
  var staff: Staff = _
  var poison: Poison = _
  var paralize: Paralize = _

  override def beforeEach(context: BeforeEach): Unit = {
    gameController = new GameController()
    warrior = new Warrior("Warrior", 10, 10 ,28)
    paladin = new Paladin("Paladin", 10 , 10, 18)
    mage = new WhiteMage("Mage", 10, 10,10,50)
    enemy = new Enemy("Enemy", 10, 10 ,10, 16)
    sword = new Sword("Sword", 10,10,8)
    staff = new Staff("Staff", 10, 10, 10, 5)
    //weight order from least to most:
    //mage -> paladin -> warrior -> enemy
    poison = new Poison()
    paralize = new Paralize()
  }
  test("A game controller must start in the PreGame State"){
    assert(gameController.state.isInstanceOf[PreGame], true)
  }
  test("A game controller can transition into a InGame State"){
    gameController.startGame(ArrayBuffer(warrior, mage, paladin), ArrayBuffer(enemy))
    assert(gameController.state.isInstanceOf[InGame], true)
  }
  test("A game controller can make a character equip a weapon"){
    gameController.playerEquipWeapon(warrior, sword)
  }
  test("A game controller can make a mage cast a spell"){
    gameController.startGame(ArrayBuffer(mage, paladin,warrior), ArrayBuffer(enemy))
    gameController.playerEquipWeapon(mage, staff)
    gameController.turnScheduler.enqueueCharacters()
    gameController.turnScheduler.updateCharacterActionBar(30)
    gameController.turnScheduler.setTurnCharacter(0)


    gameController.mageCast(poison, mage, enemy)

  }

  test("A game controller can make a character attack") {
    gameController.startGame(ArrayBuffer(paladin), ArrayBuffer())
    gameController.playerEquipWeapon(paladin, sword)
    gameController.turnScheduler.enqueueCharacters()
    gameController.turnScheduler.updateCharacterActionBar(30)
    gameController.turnScheduler.setTurnCharacter(0)
    println(gameController.turnScheduler.turnCharacter)

    gameController.unitAttack(paladin, enemy)

  }
  test("A game controller can pass a turn to the next character") {
    gameController.startGame(ArrayBuffer(mage, paladin, warrior), ArrayBuffer())
    gameController.playerEquipWeapon(mage, staff)
    gameController.turnScheduler.enqueueCharacters()
    gameController.turnScheduler.updateCharacterActionBar(30)
    gameController.turnScheduler.setTurnCharacter(0)
    //turn character = mage
    gameController.passTurn(gameController.turnScheduler.turnCharacter)
    //turn character = paladin


    assertEquals(gameController.turnScheduler.turnCharacter, paladin)
  }

  test("A game controller can end the game when the party is defeated"){
    gameController.startGame(ArrayBuffer(mage, paladin, warrior), ArrayBuffer(enemy))
    //Every party member will die
    for (partymember <-gameController.party.currentParty){
      partymember.setHp(0)
    }
    gameController.endGame()
    assert(gameController.state.isInstanceOf[EndGame])
  }

  test("A game controller can end the game when the enemies have been defeated"){
    gameController.startGame(ArrayBuffer(mage, paladin, warrior), ArrayBuffer(enemy))
    enemy.setHp(0)
    gameController.endGame()
    assert(gameController.state.isInstanceOf[EndGame])
  }

  test("A game controller can skip a paralized enemy turn"){
    gameController.startGame(ArrayBuffer(mage, paladin, warrior), ArrayBuffer(enemy))
    gameController.playerEquipWeapon(mage, staff)
    gameController.turnScheduler.enqueueCharacters()
    gameController.turnScheduler.updateCharacterActionBar(30)
    gameController.turnScheduler.setTurnCharacter(0)
    //turn character = mage
    gameController.mageCast(paralize, mage, enemy)
    gameController.passTurn(gameController.turnScheduler.turnCharacter)
    //turn character = enemy
    //turn gets skipped because enemy is paralized
    //turn character = paladin
    assertEquals(gameController.turnScheduler.turnCharacter, paladin)
  }

  test("A game controller can apply damage effects on an enemy's turn"){
    gameController.startGame(ArrayBuffer(mage, paladin, warrior), ArrayBuffer(enemy))
    gameController.playerEquipWeapon(mage, staff)
    gameController.turnScheduler.enqueueCharacters()
    gameController.turnScheduler.updateCharacterActionBar(30)
    gameController.turnScheduler.setTurnCharacter(0)
    //turn character = mage
    gameController.mageCast(poison, mage, enemy)
    val damage = staff.getMagicDamage / 3
    val expected_hp = enemy.getHp - damage
    gameController.passTurn(gameController.turnScheduler.turnCharacter)
    // turn character = enemy gets applied poison dmg
    assertEquals(enemy.getHp, expected_hp)

  }

}
