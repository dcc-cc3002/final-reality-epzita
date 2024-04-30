package model.armory

/**
 *
 * @param name name of the sword
 * @param damage damage of the sword
 * @param defense defense stat
 * @param weight weight of the weapon, affects turn position during combat
 */
class Sword(val name: String,
            var damage: Int,
            val defense: Int,
            val weight: Int) extends PhysicalWeapon {



}
