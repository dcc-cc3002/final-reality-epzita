package model.character

import model.armory.Weapon


/**
 * Abstracts class which extends from ACharacter, built to have a better
 * design when it comes to implementing Mage characters
 * Adds the mp (mana points) attribute
 */
abstract class AMagicCharacter extends ACharacter {
  val name: String
  var hp: Int
  var defense: Int
  val weight: Int
  var mp: Int
}
