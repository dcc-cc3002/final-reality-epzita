package model.character.specializations

import model.armory.PhysicalWeapon
import model.character.{ACharacter, APhysicalCharacter}

/**
 *
 * @param name name of the character
 * @param hp  health points
 * @param defense defense capability
 * @param weight weight, determines positions during turns
 */

class Warrior (val name: String,
               protected var hp: Int,
               protected var defense: Int,
               val weight: Int) extends APhysicalCharacter{


}