package model.turnScheduler

import model.character.Character

import scala.collection.mutable.ArrayBuffer

abstract class ATurnScheduler extends ITurnScheduler {

  val fightingCharacters: ArrayBuffer[Character] = new ArrayBuffer[Character]
  val waitList: ArrayBuffer[Character] = new ArrayBuffer[Character]
  val fightList: ArrayBuffer[Character] = new ArrayBuffer[Character]

  def addNewCharacter(p: Character): Unit = {
    this.fightingCharacters.addOne(p)
  }

  def removeCharacter(p: Character): Unit = {
    val index = this.fightingCharacters.indexOf(p)
    this.fightingCharacters.remove(index)
  }


  def setCharacterMaxActionBar(characters: ArrayBuffer[Character]): Unit = {
    for (character <- characters) {
      character.setMaxActionBar()
    }
  }

  def resetCharacterActionBar(characters: ArrayBuffer[Character]): Unit = {
    for(character <- characters){
      character.actionBar = 0
    }
  }


  def updateCharacterActionBar(k: Int, characters: ArrayBuffer[Character]): Unit = {
    for (character <- characters) {
      character.actionBar += k
      if (character.actionBar >= character.maxActionBar) {
      }
    }
  }

}
