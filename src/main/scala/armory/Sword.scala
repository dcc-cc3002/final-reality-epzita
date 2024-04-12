package armory

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

  /**
   * damage getter
   * @return damage
   */
  def getDamage(): Int = {
    this.damage
  }

  /**
   * damage setter
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

}
