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
    false
  }


}
