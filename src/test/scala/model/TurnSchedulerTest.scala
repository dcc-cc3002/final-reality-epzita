package model

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
}
