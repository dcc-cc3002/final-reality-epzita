package model.character

/**
 * Abstract class representing a game unit in a role-playing game.
 *
 * This class provides a base structure for both enemies and characters, defining common attributes and behaviors.
 */
abstract class AGameUnit extends GameUnit {

  /** The name of the game unit. */
  val name: String

  /** The current hit points of the game unit. */
  protected var hp: Int

  /** The defense power of the game unit. */
  protected var defense: Int

  /** The weight of the game unit, used for determining the maximum action bar value. */
  val weight: Int

  /** The maximum value of the action bar for the game unit, based on its weight. */
  protected var maxActionBar: Int = weight

  /** The current value of the action bar for the game unit. */
  protected var actionBar = 0

  /**
   * Returns the current hit points of the game unit.
   *
   * @return The current hit points of the game unit.
   */
  override def getHp: Int = {
    this.hp
  }

  /**
   * Sets the hit points of the game unit to the given value.
   *
   * @param hp The new hit points value.
   */
  def setHp(hp: Int): Unit = {
    this.hp = hp
  }

  /**
   * Returns the defense power of the game unit.
   *
   * @return The defense power of the game unit.
   */
  override def getDefense: Int = {
    this.defense
  }

  /**
   * Returns the maximum value of the action bar for the game unit.
   *
   * @return The maximum value of the action bar for the game unit.
   */
  override def getMaxActionBar(): Int = this.maxActionBar

  /**
   * Sets the maximum value of the action bar for the game unit based on its weight.
   */
  def setMaxActionBar(): Unit = {
    this.actionBar = this.weight
  }

  /**
   * Returns the current value of the action bar for the game unit.
   *
   * @return The current value of the action bar for the game unit.
   */
  override def getActionBar(): Int = this.actionBar

  /**
   * Sets the current value of the action bar for the game unit.
   *
   * @param actionBar The new value of the action bar.
   */
  override def setActionBar(actionBar: Int): Unit = {
    this.actionBar = actionBar
  }

  /**
   * Abstract method for attacking another game unit.
   *
   * @param target The game unit to attack.
   */
  def attack(target: GameUnit): Unit

}

