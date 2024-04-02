package character

//valores previsorios?
//pq sale icono scala y no el de clase
//que hacer con los val en la clase

class Paladin (val name: String,
             var hp: Int,
             var defense: Int,
             val weight: Int) extends Character{
}

class Warrior (val name: String,
             var hp: Int,
             var defense: Int,
             val weight: Int) extends Character{
}

class Ninja (val name: String,
              var hp: Int,
              var defense: Int,
              val weight: Int) extends Character{
}

class WhiteMage (val name: String,
                 var hp: Int,
                 var defense: Int,
                 val weight: Int,
                 var mp: Int) extends MagicCharacter
{

}

class BlackMage (val name: String,
                 var hp: Int,
                 var defense: Int,
                 val weight: Int,
                 var mp: Int) extends MagicCharacter
{

}