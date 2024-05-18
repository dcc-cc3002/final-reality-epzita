package model.character

/**
 * Abstract class representing an enemy in a role-playing game.
 *
 * This class defines the common properties and behavior of enemies in the game.
 */
abstract class AEnemy extends GameUnit {
  /** The name of the enemy. */
  val name: String
  /** The current hit points of the enemy. */
  protected var hp: Int
  /** The attack power of the enemy. */
  var attack: Int
  /** The defense power of the enemy. */
  protected var defense: Int
  /** The weight of the enemy, used for determining the maximum action bar value. */
  val weight: Int

  /** The maximum value of the action bar for the enemy, based on its weight. */
  var maxActionBar: Int = weight
  /** The current value of the action bar for the enemy. */
  var actionBar = 0

  /**
   * Returns the current hit points of the enemy.
   *
   * @return The current hit points of the enemy.
   */
  override def getHp: Int = {
    this.hp
  }

  /**
   * Sets the hit points of the enemy to the given value.
   *
   * @param hp The new hit points value.
   */
  def setHp(hp: Int): Unit = {
    this.hp = hp
  }

  /**
   * Returns the defense power of the enemy.
   *
   * @return The defense power of the enemy.
   */
  override def getDefense: Int = {
    this.defense
  }

  /**
   * Sets the maximum value of the action bar for the enemy based on its weight.
   */
  override def setMaxActionBar(): Unit = {
    this.maxActionBar = this.weight
  }

  /**
   * Attacks the given character, reducing their hit points based on the enemy's attack and the character's defense.
   *
   * @param character The character to attack.
   */
  def attack(character: Character): Unit = {
    character.setHp(character.getHp + character.getDefense - this.attack)
  }

  /**
   * Indicates whether this object is an enemy.
   *
   * @return `true` if this object is an enemy, `false` otherwise.
   *
   * @note This method has been implemented for the Enemy class to be instantiated and tested.
   */
  def isEnemy: Boolean = {
    true
  }
}


