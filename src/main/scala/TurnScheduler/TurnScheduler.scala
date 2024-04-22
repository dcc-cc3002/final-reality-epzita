package TurnScheduler
import character.Person

import scala.collection.mutable.ArrayBuffer


/*+
this is a really rough version of the turn scheduler class, it still needs a lot of work, didnt have enough time to test
it either
 */
class TurnScheduler {
  /**
   * this lists contains the characters fighting
   * fightingCharacters contains all characters (and enemies) fighting
   * when a character dies, he gets remove from this list
   * waitList contains every characters that hasn't been given a turn position yet
   * fightList contains every character in order for each turn
   */
  val fightingCharacters: ArrayBuffer[Person] = new ArrayBuffer[Person]
  val waitList: ArrayBuffer[Person] = new ArrayBuffer[Person]
  val fightList: ArrayBuffer[Person] = new ArrayBuffer[Person]


  def addNewCharacter(p: Person): Unit = {
    fightingCharacters.addOne(p)
  }

  def removeCharacter(p: Person): Unit = {
    fightingCharacters -= p
  }
}

  def characterMaxActionBar(characters: ArrayBuffer[Person]): Unit = {
    for (character <- characters){
      character.maxActionBar = character.weight /** this has to be change if character is enemy or player */

    }
  }

/**
 *
 * @param characters will receive waitList and add characters to FightList
 * waitList and fightList out of scope?
 * function needs a while loop, every iteration increases character's action bar by k
 * removers character from waitlist and adds him to the fightlist in order
 */
def turnPosition(characters: ArrayBuffer[Person], waitList: ArrayBuffer[Person], fightList: ArrayBuffer[Person], k: Int): Unit = {
    for(character <- characters){
      // when to set actionBar to 0?
      character.actionBar = 0
      character.actionBar += k
      if(character.actionBar >= character.maxActionBar){
        waitList -= character
        fightList += character
      }
    }
  }
