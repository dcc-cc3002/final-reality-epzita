package model.armory

/**
 * Trait representing a magical weapon in a role-playing game.
 * Classes implementing this trait define methods related to magic damage.
 */
trait IMagicWeapon {

  /**
   * Returns the amount of magic damage inflicted by the weapon.
   *
   * @return The magic damage inflicted by the weapon.
   */
  def getMagicDamage: Int
}

