package model.character

/**
 * Abstract class representing a physical character.
 *
 * This class extends ACharacter and defines the common properties and behavior of physical characters in the game.
 */
abstract class APhysicalCharacter extends ACharacter {
  /** The name of the physical character. */
  val name: String
  /** The current hit points of the physical character. */
  protected var hp: Int
  /** The defense power of the physical character. */
  protected var defense: Int
  /** The weight of the physical character, used for determining the maximum action bar value. */
  val weight: Int
}
