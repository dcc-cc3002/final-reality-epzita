package model.turnscheduler

import model.armory.Sword
import model.character.Enemy
import model.character.specializations.{Paladin, Warrior}
import model.turnscheduler.TurnScheduler
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class TurnSchedulerTest extends FunSuite {
  var warrior: Warrior = _
  var sword: Sword = _
  var dummy: Paladin = _
  var enemy: Enemy = _
  var woodenSword: Sword = _
  var turnScheduler : TurnScheduler =_

  override def beforeEach(context: BeforeEach): Unit = {
    warrior = new Warrior("Pepsita", 35, 8, 20)
    dummy = new Paladin("Dummy", 30, 5, 25)
    woodenSword = new Sword("Stick", 1, 10, 10)
    enemy = new Enemy("Bad guy", 10, 8, 5, 30)
    turnScheduler = new TurnScheduler()
  }

  test("A turn scheduler can add characters") {
    turnScheduler.addNewCharacter(warrior)
    turnScheduler.addNewCharacter(dummy)
    turnScheduler.addNewCharacter(enemy)
    val expected = ArrayBuffer(warrior, dummy, enemy)
    assertEquals(turnScheduler.fightingCharacters, expected)
  }

  test("A turn scheduler can remove a character"){
    turnScheduler.addNewCharacter(warrior)
    turnScheduler.addNewCharacter(dummy)
    turnScheduler.addNewCharacter(enemy)
    val expected = ArrayBuffer(warrior, enemy)
    turnScheduler.removeCharacter(dummy)
    assertEquals(turnScheduler.fightingCharacters, expected)
  }

  test("A turn scheduler can set its character's maxActionBar"){
    turnScheduler.addNewCharacter(warrior)
    turnScheduler.addNewCharacter(dummy)
    turnScheduler.addNewCharacter(enemy)

    warrior.equipWeapon(woodenSword)

    turnScheduler.setCharacterMaxActionBar(turnScheduler.fightingCharacters)

    val warriorExpected = warrior.weight + woodenSword.weight
    assertEquals(warrior.getMaxActionBar(), warriorExpected)
    assertEquals(dummy.getMaxActionBar(), dummy.weight)
    assertEquals(enemy.getMaxActionBar(), enemy.weight)
  }

  test("A turn scheduler can access its characters actionBar"){
    turnScheduler.addNewCharacter(warrior)
    //A character's default actionBar is set on 0
    assertEquals(turnScheduler.fightingCharacters(0).getActionBar(), 0)
  }



  test("A turn scheduler can reset its character's actionBar"){
    turnScheduler.addNewCharacter(warrior)
    turnScheduler.addNewCharacter(enemy)

    //we set the character's action bar to be different than 0
    turnScheduler.enqueueCharacters()
    turnScheduler.updateCharacterActionBar(5)

    turnScheduler.resetCharacterActionBar(turnScheduler.waitList)

    assertEquals(turnScheduler.waitList(0).getActionBar(), 0)
    assertEquals(turnScheduler.waitList(1).getActionBar(), 0)
  }

  test("A turn scheduler can add its characters to a waitList before assigning a turn order"){
    turnScheduler.addNewCharacter(warrior)
    turnScheduler.addNewCharacter(dummy)
    turnScheduler.addNewCharacter(enemy)

    turnScheduler.enqueueCharacters()

    assertEquals(turnScheduler.fightingCharacters, turnScheduler.waitList)
  }

  test("A turn scheduler can increase its character's actionBar") {
    turnScheduler.addNewCharacter(warrior)
    turnScheduler.addNewCharacter(enemy)

    turnScheduler.enqueueCharacters()
    turnScheduler.updateCharacterActionBar(5)

    assertEquals(turnScheduler.waitList(0).getActionBar(), 5)
    assertEquals(turnScheduler.waitList(1).getActionBar(), 5)

    turnScheduler.updateCharacterActionBar(2)

    assertEquals(turnScheduler.waitList(0).getActionBar(), 7)
    assertEquals(turnScheduler.waitList(1).getActionBar(), 7)
  }

  test("A turn scheduler can give its character a turn order"){
    turnScheduler.addNewCharacter(warrior)
    turnScheduler.addNewCharacter(dummy)
    turnScheduler.addNewCharacter(enemy)

    turnScheduler.enqueueCharacters()

    turnScheduler.updateCharacterActionBar(30)

    //weight comparison:
    //warrior < dummy < enemy
    val expected = ArrayBuffer(warrior, dummy, enemy)
    assertEquals(turnScheduler.fightList, expected)
  }

  test("A turn scheduler knows who's turn is it"){
    turnScheduler.addNewCharacter(warrior)
    turnScheduler.addNewCharacter(dummy)
    turnScheduler.addNewCharacter(enemy)

    turnScheduler.enqueueCharacters()
    turnScheduler.updateCharacterActionBar(30)
    turnScheduler.setTurnCharacter()

    assertEquals(turnScheduler.turnCharacter, warrior)
  }

}
