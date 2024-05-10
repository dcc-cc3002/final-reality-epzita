package model.armory

/**
 *
 * @param name name of the staff
 * @param damage physical damage of the staff
 * @param magicDamage magic damage
 * @param defense defense stat
 * @param weight weight of the weapon, impacts turn position during combat
 */
class Staff(val name: String,
            protected var damage: Int,
            protected var magicDamage: Int,
            protected val defense: Int,
            val weight: Int) extends MagicWeapon {



}
