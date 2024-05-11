package model.character

/**
 * main interface to create characters and enemies
 */
trait Character {
  val name: String
  protected var hp: Int
  protected var defense: Int
  val weight: Int

  var maxActionBar: Int
  var actionBar: Int

  def attack(character: Character): Unit
  def setMaxActionBar(): Unit
  def getHp: Int
  def setHp(hp: Int): Unit
  def getDefense: Int

}
