package model.character

import exceptions.{InsufficientManaException, InvalidSpellException}
import model.armory.Weapon
import model.sorcery.Spell


/**
 * Abstract class extending ACharacter, designed for implementing Mage characters.
 *
 * This class adds the mana points (mp) attribute to the character.
 */
abstract class AMagicCharacter extends ACharacter with MagicCharacter {
  /** The name of the character. */
  val name: String
  /** The current hit points of the character. */
  protected var hp: Int
  /** The defense power of the character. */
  protected var defense: Int
  /** The weight of the character, used for determining the maximum action bar value. */
  val weight: Int
  /** The current mana points of the character. */
  var mp: Int


  /**
   * Returns the current mana points of the character.
   *
   * @return The current mana points of the character.
   */
  def getMp: Int = {
    this.mp
  }
  def setMp(newMana: Int): Unit = {
    this.mp = newMana
  }

  def castSpell(spell: Spell, target: GameUnit): Unit = {

    if(spell.canBeCastBy(this)){
      if(this.getMp >= spell.manaCost){
        spell.cast(this, target)
        this.setMp(this.getMp - spell.manaCost)
      }
      else{
        throw new InsufficientManaException("This Mage doesn't have enough mana to cast this Spell")
      }
    }
    else{
      throw new InvalidSpellException("This Mage can't cast this kind of Magic")
    }
  }

}
