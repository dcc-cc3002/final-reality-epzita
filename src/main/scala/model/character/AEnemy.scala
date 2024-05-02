package model.character

abstract class AEnemy extends Character {
  /** Enemy's stats */
  val name: String
  var hp: Int
  val attack: Int
  var defense: Int
  val weight: Int

  var maxActionBar = 0
  var actionBar = 0

  /**
   * this method has been implemented just for the Enemy class to be instanced and tested
   */
  def isEnemy: Boolean = {
    true
  }

}
