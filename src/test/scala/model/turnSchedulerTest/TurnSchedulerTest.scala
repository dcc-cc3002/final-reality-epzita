package model.turnSchedulerTest

import model.armory.Sword
import model.character.Enemy
import model.character.specializations.{Paladin, Warrior}
import model.turnScheduler.TurnScheduler
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
    warrior = new Warrior("Pepsita", 35, 8, 62)
    dummy = new Paladin("Dummy", 30, 5, 10)
    sword = new Sword("Excalibur", 10, 10, 10)
    woodenSword = new Sword("Stick", 1, 10, 10)
    enemy = new Enemy("Bad guy", 10, 8, 5, 20)
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
    assertEquals(warrior.maxActionBar, warriorExpected)
    assertEquals(dummy.maxActionBar, dummy.weight)
    assertEquals(enemy.maxActionBar, enemy.weight)
  }

  test("A turn scheduler can access its characters actionBar"){
    turnScheduler.addNewCharacter(warrior)
    //A character's default actionBar is set on 0
    assertEquals(turnScheduler.fightingCharacters(0).actionBar, 0)
  }

  test("A turn scheduler can increase its character's actionBar"){
    turnScheduler.addNewCharacter(warrior)
    turnScheduler.addNewCharacter(enemy)

    turnScheduler.updateCharacterActionBar(5, turnScheduler.fightingCharacters)

    assertEquals(turnScheduler.fightingCharacters(0).actionBar, 5)
    assertEquals(turnScheduler.fightingCharacters(1).actionBar, 5)

    turnScheduler.updateCharacterActionBar(2, turnScheduler.fightingCharacters)

    assertEquals(turnScheduler.fightingCharacters(0).actionBar, 7)
    assertEquals(turnScheduler.fightingCharacters(1).actionBar, 7)
  }

  test("A turn scheduler can reset its character's actionBar"){
    turnScheduler.addNewCharacter(warrior)
    turnScheduler.addNewCharacter(enemy)

    //we set the character's action bar to be different than 0
    turnScheduler.updateCharacterActionBar(5, turnScheduler.fightingCharacters)

    turnScheduler.resetCharacterActionBar(turnScheduler.fightingCharacters)

    assertEquals(turnScheduler.fightingCharacters(0).actionBar, 0)
    assertEquals(turnScheduler.fightingCharacters(1).actionBar, 0)

  }
}
