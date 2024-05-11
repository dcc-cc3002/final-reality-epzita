package model.character

abstract class AEnemy extends Character {
  /** Enemy's stats */
  val name: String
  protected var hp: Int
  var attack: Int
  protected var defense: Int
  val weight: Int

  var maxActionBar: Int = weight
  var actionBar = 0

  override def getHp: Int = {
    this.hp
  }
  def setHp(hp: Int): Unit = {
    this.hp = hp
  }
  override def getDefense: Int = {
    this.defense
  }
  override def setMaxActionBar(): Unit = {
    this.maxActionBar = this.weight
  }

  override def attack(character: Character): Unit = {
    character.setHp(character.getHp + character.getDefense - this.attack)
  }
  /**
   * this method has been implemented just for the Enemy class to be instanced and tested
   */
  def isEnemy: Boolean = {
    true
  }

}
