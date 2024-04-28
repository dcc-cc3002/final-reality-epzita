package model.character

/**
 * main interface to create characters and enemies
 */
trait Person {
  val name: String
  var hp: Int
  var defense: Int
  val weight: Int

  var maxActionBar: Int
  var actionBar: Int

}
