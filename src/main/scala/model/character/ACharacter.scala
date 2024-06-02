package model.character

import exceptions.{InvalidTargetException, Require, WeaponNotFoundException}
import model.armory.Weapon

/**
 * Abstract class defining a character in a role-playing game.
 *
 * This class provides a base structure for character specializations, such as Warriors and Mages.
 */
abstract class ACharacter extends Character {
  /** The name of the character. */
  val name: String
  /** The current health points of the character. */
  protected var hp: Int
  /** A character cannot be initialized with negative health points. */
  protected var _hp: Int = Require.Stat(hp, "hp") atLeast(0)

  /** The defense power of the character. */
  protected var defense: Int
  /** A character cannot be initialized with negative defense. */
  protected var _defense: Int = Require.Stat(defense, "defense") atLeast(0)
  /** The weight of the character, used for determining the maximum action bar value. */
  val weight: Int
  /** A character cannot be initialized with negative weight. */
  protected var _weight: Int = Require.Stat(weight, "weigth") atLeast(0)

  /** The weapon currently equipped by the character. */
  var weapon: Option[Weapon] = None

  /** The maximum value of the action bar for the character. */
  var maxActionBar: Int = weight
  /** The current value of the action bar for the character. */
  var actionBar = 0


  /**
   * Returns the current hit points of the character.
   *
   * @return The current hit points of the character.
   */
  override def getHp: Int = {
    this.hp
  }

  /**
   * Sets the hit points of the character to the given value.
   *
   * @param hp The new hit points value.
   */
  override def setHp(hp: Int): Unit ={
      this.hp = hp
  }

  /**
   * Returns the defense power of the character.
   *
   * @return The defense power of the character.
   */
  override def getDefense: Int = {
    this.defense
  }

  /**
   * Sets the maximum value of the action bar for the character.
   *
   * If a weapon is equipped, the maximum action bar value is the sum of the character's weight and the weapon's weight.
   * Otherwise, it is just the character's weight.
   */
  override def setMaxActionBar(): Unit = {
    if (weapon.isDefined) {
      this.maxActionBar = this.weight + weapon.get.weight
    }
    else  {
      this.maxActionBar = this.weight
    }
  }

  override def canBeAttackedBy(character: Character): Boolean = false

  override def canBeAttackedBy(enemy: Enemy): Boolean = true

  /**
   * Attacks the given target, reducing their hit points based on the character's attack power and the target's defense.
   *
   * If the character has no weapon equipped, a message is printed indicating that the character has no weapon.
   *
   * @param target The target to attack.
   */
  def attack(target: AGameUnit): Unit = {
    if(target.canBeAttackedBy(this)){
      if (weapon.isDefined) {
        val damage = weapon.get.getDamage - target.getDefense
        if (damage > 0) {
          target.setHp(target.getHp - damage)
        } else {
          target.setHp(target.getHp)
        }
      } else {
        throw new WeaponNotFoundException("This character doesn't have a weapon equipped")
      }
    }else{
      throw new InvalidTargetException("A Character can only attack Enemy units")
    }


  }

  /**
   * Equips the given weapon to the character.
   *
   * If the character already has a weapon equipped, it is unequipped before equipping the new weapon.
   *
   * @param weapon The weapon to equip.
   */
  def equipWeapon(weapon: Weapon): Unit

  /**
   * Unequips the currently equipped weapon from the character.
   */
  def unequipWeapon(): Unit = {
    this.weapon = None
    this.setMaxActionBar()
  }

  /**
   * Checks if the character has a weapon equipped.
   *
   * @return true if the character has a weapon equipped, false otherwise.
   */
  def hasWeapon: Boolean = {
    this.weapon.isDefined
  }
}


