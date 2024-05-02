package model.armory

import model.character.{ACharacter, AMagicCharacter, Character}

/**
 * magic weapon, extends from weapon and adds magic damage parameter
 */
abstract class MagicWeapon extends Weapon {
  val name: String
  var damage: Int
  var magicDamage: Int
  val defense: Int
  val weight: Int

  var owner: Option[Character] = None

  /**
   * magic damage getter
   * @return magic damage stat
   */
  def getMagicDamage(): Int = {
    this.magicDamage
  }

  /**
   * magic damage setter, increases current magic damage by num
   *
   * @param num stat increase
   */
  def setMagicDamage(num: Int): Unit = {
    this.magicDamage = this.magicDamage + num
  }

  /**
   * method to test this type of weapon, increases magic damage by 2
   */
  def enhance(): Unit = {
    setMagicDamage(2)
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
