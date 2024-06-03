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
  protected var maxActionBar: Int = weight
  /** The current value of the action bar for the enemy. */
  protected var actionBar = 0

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

  override def getMaxActionBar(): Int = this.maxActionBar
  /**
   * Sets the maximum value of the action bar for the enemy based on its weight.
   */
  def setMaxActionBar(): Unit = {
    this.actionBar = this.weight
  }

  override def getActionBar(): Int = this.actionBar

  override def setActionBar(actionBar: Int): Unit = {
    this.actionBar = actionBar
  }

  /**
   * Attacks the given character, reducing their hit points based on the enemy's attack and the character's defense.
   *
   * @param target The character to attack.
   */
  def attack(target: GameUnit): Unit

}
