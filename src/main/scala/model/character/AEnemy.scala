package model.character

abstract class AEnemy extends Character {
  /** Enemy's stats */
  val name: String
  var hp: Int
  var attack: Int
  var defense: Int
  val weight: Int

  var maxActionBar: Int = weight
  var actionBar = 0

  override def setMaxActionBar(): Unit = {
    this.maxActionBar = this.weight
  }

  override def attack(character: Character): Unit = {
    character.hp -= this.attack - character.defense
  }
  /**
   * this method has been implemented just for the Enemy class to be instanced and tested
   */
  def isEnemy: Boolean = {
    true
  }

}
