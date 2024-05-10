package model.armory

import model.character.Character

/**
 * abstract class that helps create only physical type weapons
 */
abstract class PhysicalWeapon extends Weapon{
  val name: String
  protected var damage: Int
  protected val defense: Int
  val weight: Int

  var owner: Option[Character] = None

  /**
   * damage getter
   *
   * @return damage
   */
  override def getDamage: Int = {
    this.damage
  }

  override def getDefense: Int = {
    this.defense
  }

  /**
   * damage setter
   *
   * @param num increases current damage by num
   */
  def setDamage(num: Int): Unit = {
    this.damage = this.damage + num
  }

  /**
   * method created to test this kind of weapon, increases damage by 2
   */
  def sharp(): Unit = {
    damage += 2
  }

  def setOwner(character: Character): Unit = {
    if (owner.isEmpty) {
      this.owner = Some(character)
    }
  }
  def leaveOwner(): Unit = {
    this.owner = None
  }

}
