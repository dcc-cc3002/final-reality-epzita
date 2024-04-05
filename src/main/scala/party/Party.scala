package party
import character.Character
import scala.collection.mutable.ArrayBuffer

class Party {

  val currentParty: ArrayBuffer[Character] = new ArrayBuffer[Character]
  def addCharacter(character: Character): Unit = {
    currentParty.addOne(character)
  }

  def isDefeated: Boolean = {
    //for character in party if character.hp == 0 return true (comparar y verificar todos?)
    var total_hp: Int = 0;
    for(character <- currentParty){
      total_hp = total_hp + character.hp
    }
    total_hp == 0;
  }


}
