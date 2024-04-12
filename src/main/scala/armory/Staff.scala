package armory

/**
 *
 * @param name name of the staff
 * @param damage physical damage of the staff
 * @param magicDamage magic damage
 * @param defense defense stat
 * @param weight weight of the weapon, impacts turn position during combat
 */
class Staff(val name: String,
            var damage: Int,
            var magicDamage: Int,
            val defense: Int,
            val weight: Int) extends MagicWeapon {

  /**
   * magic damage getter
   * @return magic damage stat
   */
  def getMagicDamage(): Int = {
    this.magicDamage
  }

  /**
   *  magic damage setter, increases current magic damage by num
   * @param num stat increase
   */
  def setMagicDamage(num: Int): Unit = {
    this.magicDamage = this.magicDamage + num
  }

  /**
   * method to test this type of weapon, increases magic damage by 2
   */
  def enhance(): Unit ={
    setMagicDamage(2)
  }

}
