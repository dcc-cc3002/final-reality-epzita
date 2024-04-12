package exceptions.characterExceptions

import character.Enemy
import munit.FunSuite

class EnemyTest extends FunSuite {
  var enemy : Enemy = _

  override def beforeEach(context: BeforeEach): Unit = {
    enemy = new Enemy("Sauron", 100, 50, 40 , 30)
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
    assertEquals(enemy.isEnemy(), true)
  }

}
