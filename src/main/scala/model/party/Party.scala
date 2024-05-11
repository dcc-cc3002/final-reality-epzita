package model.party

import model.character.Character
import scala.collection.mutable.ArrayBuffer

/**
 * Class representing a party of characters in a role-playing game.
 *
 * This class manages a group of characters who are part of the player's party.
 */
class Party {
  /** The current members of the party. */
  val currentParty: ArrayBuffer[Character] = new ArrayBuffer[Character]

  /**
   * Adds a character to the party.
   *
   * @param member The character to add to the party.
   */
  def addMember(member: Character): Unit = {
    currentParty.addOne(member)
  }

  /**
   * Determines whether the party has been defeated.
   *
   * A party is considered defeated if the total hit points of all party members are zero.
   *
   * @return true if the party has been defeated, false otherwise.
   */
  def isDefeated: Boolean = {
    var total_hp: Int = 0
    for (partyMember <- currentParty) {
      total_hp = total_hp + partyMember.getHp
    }
    total_hp == 0
  }
}
