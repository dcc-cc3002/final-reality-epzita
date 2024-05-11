package model.character

abstract class APhysicalCharacter extends ACharacter{
  val name: String
  protected var hp: Int
  protected var defense: Int
  val weight: Int
}
