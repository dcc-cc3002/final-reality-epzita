package model.armory

import model.character.Person

/**
 * abstract class that helps create only physical type weapons
 */
abstract class PhysicalWeapon extends Weapon{
  val name: String
  var damage: Int
  val defense: Int
  val weight: Int

  var owner: Option[Person] = None

  /**
   * damage getter
   *
   * @return damage
   */
  def getDamage(): Int = {
    this.damage
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

  def setOwner(character: Person): Unit = {
    if (owner.isEmpty) {
      this.owner = Some(character)
    }
  }
  def leaveOwner(): Unit = {
    this.owner = None
  }

}
