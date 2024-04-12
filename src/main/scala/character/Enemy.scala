package character

/**
 *
 * @param name name of the enemy
 * @param hp health points
 * @param attack attack damage of the enemy
 * @param defense defense points
 * @param weight weight, helps determine position during combat turns
 */
class Enemy(val name: String, var hp: Int,
  val attack: Int,
  var defense: Int,
  val weight: Int)  extends Person{

  /**
   * this method has been implemented just for the Enemy class to be instanced and tested
   */
  def isEnemy(): Boolean ={
    true
  }

}
