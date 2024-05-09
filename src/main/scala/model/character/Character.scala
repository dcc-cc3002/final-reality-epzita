package model.character

/**
 * main interface to create characters and enemies
 */
trait Character {
  val name: String
  var hp: Int
  var defense: Int
  val weight: Int

  var maxActionBar: Int
  var actionBar: Int

  def attack(character: Character): Unit
  def setMaxActionBar(): Unit

}
