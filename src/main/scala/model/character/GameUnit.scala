package model.character

trait GameUnit {

  def getMaxActionBar(): Int
  /**
   * Sets the maximum value of the action bar for the character based on its weight.
   */
  def setMaxActionBar(): Unit

  def getActionBar(): Int
  def setActionBar(actionBar: Int)

  /**
   * Returns the current hit points of the character.
   *
   * @return The current hit points of the character.
   */
  def getHp: Int

  /**
   * Sets the hit points of the character to the given value.
   *
   * @param hp The new hit points value.
   */
  def setHp(hp: Int): Unit

  /**
   * Returns the defense power of the character.
   *
   * @return The defense power of the character.
   */
  def getDefense: Int

  def canBeAttackedBy(enemy: Enemy): Boolean

  def canBeAttackedBy(character: Character): Boolean
}
