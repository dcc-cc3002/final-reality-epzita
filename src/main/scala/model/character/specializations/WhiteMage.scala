package model.character.specializations

import model.armory.MagicWeapon
import model.character.AMagicCharacter

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
                 var mp: Int) extends AMagicCharacter {

}
