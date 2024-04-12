package character.specializations

import armory.MagicWeapon
import character.MagicCharacter

/**
 *
 * @param name name of the character
 * @param hp  health points
 * @param defense defense capability
 * @param weight weight, determines positions during turns
 * @param mp mana points, indicates what spells the character can cast
 */

class WhiteMage (val name: String,
                 var hp: Int,
                 var defense: Int,
                 val weight: Int,
                 var mp: Int) extends MagicCharacter {


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
