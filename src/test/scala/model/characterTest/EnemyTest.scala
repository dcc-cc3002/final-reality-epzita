package model.characterTest

import model.character.Enemy
import model.character.specializations.Paladin
import munit.FunSuite

class EnemyTest extends FunSuite {
  var enemy : Enemy = _
  var dummy: Paladin = _

  override def beforeEach(context: BeforeEach): Unit = {
    enemy = new Enemy("Sauron", 100, 50, 40 , 30)
    dummy = new Paladin("Dummy", 30,5,10)
  }

  test("Checking correct asignment of enemy stats") {
    assertEquals(enemy.name, "Sauron")
  }

  test("Checking hp") {
    assertEquals(enemy.hp, 100)
  }

  test("Checking defense") {
    assertEquals(enemy.attack, 50)
  }

  test("Checking weight") {
    assertEquals(enemy.defense, 40)
  }

  test("Checking weight"){
    assertEquals(enemy.weight, 30)
  }

  test("Testing isEnemy method"){
    assertEquals(enemy.isEnemy, true)
  }

  test("An enemy can attack a character"){
    val expected = dummy.hp - enemy.attack + dummy.defense
    enemy.attack(dummy)
    assertEquals(dummy.hp, expected)
  }

}
