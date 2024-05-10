package model.turnScheduler

import model.character.Character

import scala.collection.mutable.ArrayBuffer

abstract class ATurnScheduler extends ITurnScheduler {

  val fightingCharacters: ArrayBuffer[Character] = new ArrayBuffer[Character]
  val waitList: ArrayBuffer[Character] = new ArrayBuffer[Character]
  val fightList: ArrayBuffer[Character] = new ArrayBuffer[Character]

  var turnCharacter: Character = _

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

  def enqueueCharacters(): Unit = {
    for(character <- this.fightingCharacters){
      waitList.addOne(character)
    }
  }
  def cleanWaitList(): Unit = {
    for(character <- fightList){
      val index = waitList.indexOf(character)
      if(index != -1){
        waitList.remove(index)
      }
    }
  }
  def updateCharacterActionBar(k: Int): Unit = {
    for (character <- waitList) {
      character.actionBar += k
      if(character.actionBar >= character.maxActionBar){
        fightList.addOne(character)
      }
    }
    this.cleanWaitList()
  }
  def setTurnCharacter(): Unit = {
    if(this.fightList.nonEmpty) {
      turnCharacter = fightList(0)
    }
    else{
      println("This turn has not yet started")
    }
  }
}
