package model.character.specializations

import model.armory.PhysicalWeapon
import model.character.ACharacter

/**
 *
 * @param name name of the character
 * @param hp  health points
 * @param defense defense capability
 * @param weight weight, determines positions during turns
 */
class Ninja(val name: String,
                var hp: Int,
                var defense: Int,
                val weight: Int) extends ACharacter {

}