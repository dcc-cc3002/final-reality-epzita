package character.specializations

import armory.PhysicalWeapon
import character.Character

/**
 *
 * @param name name of the character
 * @param hp  health points
 * @param defense defense capability
 * @param weight weight, determines positions during turns
 */

class Warrior (val name: String,
               var hp: Int,
               var defense: Int,
               val weight: Int) extends Character{

  /**
   * variable switch that helps to determine if theres a weapon equipped or not
   */
  var hasweapon = false

  /**
   * Equips a weapon triggering the hasweapon switch
   */
  def equipWeapon(): Unit = {
    hasweapon = true

  }

  /**
   * unequips a weapon triggering the hasweapon switch
   */
  def unequipWeapon(): Unit = {
    hasweapon = false
  }

  /**
   * @return boolean indicating if there is in fact a weapon equipped or not
   */
  def hasWeapon(): Boolean = {
    hasweapon
  }


}