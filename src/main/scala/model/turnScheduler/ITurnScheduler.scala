package model.turnScheduler

import scala.collection.mutable.ArrayBuffer
import model.character.Character

trait ITurnScheduler {
  val fightingCharacters: ArrayBuffer[Character]
  val waitList: ArrayBuffer[Character]
  val fightList: ArrayBuffer[Character]

  def addNewCharacter(character: Character): Unit
  def removeCharacter(character: Character): Unit
  def setCharacterMaxActionBar(characters: ArrayBuffer[Character]): Unit
  def resetCharacterActionBar(characters:ArrayBuffer[Character]): Unit
  def updateCharacterActionBar(k: Int): Unit

}
