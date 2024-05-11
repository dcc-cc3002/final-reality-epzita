package model.character

/**
 *
 * @param name name of the enemy
 * @param hp health points
 * @param attack attack damage of the enemy
 * @param defense defense points
 * @param weight weight, helps determine position during combat turns
 */
class Enemy(val name: String, protected var hp: Int,
  var attack: Int, protected var defense: Int,
  val weight: Int)  extends AEnemy{

}
