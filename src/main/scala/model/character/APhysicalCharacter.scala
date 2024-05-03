package model.character

abstract class APhysicalCharacter extends ACharacter{
  val name: String
  var hp: Int
  var defense: Int
  val weight: Int
}
