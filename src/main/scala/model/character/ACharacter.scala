package model.character

import model.armory.Weapon

/**
 * defines a the Character type which provides a base structure
 * for the rest of specializations, for example, a Warrior must be a
 * Character
 */
abstract class ACharacter extends Character {
  /** character's stats */
  val name: String
  protected var hp: Int
  protected var defense: Int
  val weight: Int

  var weapon: Option[Weapon] = None

  var maxActionBar: Int = weight
  var actionBar = 0

  override def getHp: Int = {
    this.hp
  }

  override def setHp(hp: Int): Unit ={
    this.hp = hp
  }

  override def getDefense: Int = {
    this.defense
  }

  override def setMaxActionBar(): Unit = {
    weapon match {
      case Some(weapon) =>
        this.maxActionBar = this.weight + weapon.weight

      case None =>
        this.maxActionBar = this.weight
    }
  }
/**
  override def setMaxActionBar(): Unit = {
    if (weapon.isDefined) {
      this.maxActionBar = this.weight + weapon.get.weight
    }
    else  {
      this.maxActionBar = this.weight
    }
  }

  override def attack(character: Character): Unit = {
    if (weapon.isDefined) {
      val damage = weapon.get.damage - character.defense
      if (damage > 0) {
        character.hp -= damage
      } else {
        character.hp = 0
      }
    } else {
      println(s"${this.name} no tiene un arma equipada.")
    }
  }
  */
  override def attack(character: Character): Unit = {
    weapon match {
      case Some(weapon) =>
        val damage = weapon.getDamage - character.getDefense
        if (damage > 0) {
          val currentHp = character.getHp
          character.setHp(currentHp- damage)
        }
        else {
          character.setHp(character.getHp)
        }
      case None =>
        println(s"${this.name} no tiene un arma equipada.")
    }
  }

  def equipWeapon(weapon: Weapon): Unit = {
    if (this.weapon.isEmpty) {
      this.weapon = Some(weapon)
      weapon.setOwner(this)
      this.setMaxActionBar()
    }
  }

  def unequipWeapon(): Unit = {
    this.weapon = None
    this.setMaxActionBar()
  }

  /**
   * @return boolean indicating if there is in fact a weapon equipped or not
   */
  def hasWeapon: Boolean = {
     this.weapon.isDefined
  }
}


