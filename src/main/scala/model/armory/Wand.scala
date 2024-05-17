package model.armory

class Wand (val name: String,
            protected var damage: Int,
            protected var magicDamage: Int,
            protected val defense: Int,
            val weight: Int) extends MagicWeapon {

}
