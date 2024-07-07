package model.gamecontroller

import model.armory.{Staff, Sword}
import model.character.Enemy
import model.character.specializations.{Paladin, Warrior, WhiteMage}
import model.sorcery.{Fire, Poison}
import model.state.{GameController, InGame, PreGame}
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

  override def beforeEach(context: BeforeEach): Unit = {
    gameController = new GameController()
    warrior = new Warrior("Warrior", 10, 10 ,300)
    paladin = new Paladin("Paladin", 10 , 10, 18)
    mage = new WhiteMage("Mage", 10, 10,10,50)
    enemy = new Enemy("Enemy", 10, 10 ,10, 30)
    sword = new Sword("Sword", 10,10,8)
    staff = new Staff("Staff", 10, 10, 10, 5)
    //weight order from least to most:
    //mage -> paladin -> warrior -> enemy
    poison = new Poison()
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
    gameController.startGame(ArrayBuffer(warrior, mage, paladin), ArrayBuffer(enemy))
    gameController.playerEquipWeapon(mage, staff)
    gameController.turnScheduler.enqueueCharacters()
    gameController.turnScheduler.updateCharacterActionBar(20)
    gameController.turnScheduler.setTurnCharacter()

    println(gameController.turnScheduler.fightList)
    println(mage.getMaxActionBar())
    gameController.mageCast(poison, mage, enemy)


  }

}
