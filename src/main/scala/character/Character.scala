package character

import armory.Weapon

//var o val para las stats?
abstract class Character extends Person{
  val name: String
  var hp: Int
  var defense: Int
  val weight: Int
  def equipWeapon(w: Weapon): Unit
}

//crear player y enemies como clase abstracta y que luego las clases extiendan la clase
//abstracta? como instanciar los enemigos entonces?

