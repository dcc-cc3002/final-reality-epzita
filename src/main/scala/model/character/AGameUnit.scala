package model.character

abstract class AGameUnit extends GameUnit{

  /** The name of the enemy. */
  val name: String
  /** The current hit points of the enemy. */
  protected var hp: Int

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
   * @param target The character to attack.
   */
  def attack(target: GameUnit): Unit

}
