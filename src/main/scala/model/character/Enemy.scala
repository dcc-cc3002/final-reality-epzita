package model.character

import exceptions.InvalidTargetException
import model.effects.EffectHandler

/**
 *
 * @param name name of the enemy
 * @param hp health points
 * @param attack attack damage of the enemy
 * @param defense defense points
 * @param weight weight, helps determine position during combat turns
 */
class Enemy(val name: String, protected var hp: Int,
  var attack: Int, protected var defense: Int,
  val weight: Int)  extends AEnemy{

  override def attack(target: GameUnit) = {
    if (target.canBeAttackedBy(this)) {
      val damage = this.attack - target.getDefense
      target.setHp(math.min(target.getHp - damage, target.getHp))
    }
    else {
      throw new InvalidTargetException("An enemy can only attack character Units")
    }
  }

  val effectHandler: EffectHandler = new EffectHandler(this)

  override def getEffectHandler: EffectHandler = this.effectHandler
}
