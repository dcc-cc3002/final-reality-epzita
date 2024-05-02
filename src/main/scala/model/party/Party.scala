package model.party

import model.character.Character
import scala.collection.mutable.ArrayBuffer

/**
 * Party class, creates an array containing Characters
 */
class Party {
  val currentParty: ArrayBuffer[Character] = new ArrayBuffer[Character]
  def addMember(member: Character): Unit = {
    currentParty.addOne(member)
  }

  /**
   *
   * @return state of the party
   */
  def isDefeated: Boolean = {
    //for character in party if character.hp == 0 return true (comparar y verificar todos?)
    var total_hp: Int = 0;
    for(partyMember <- currentParty){
      total_hp = total_hp + partyMember.hp
    }
    total_hp == 0;
  }


}
