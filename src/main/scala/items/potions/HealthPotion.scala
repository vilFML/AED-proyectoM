package cl.uchile.dcc
package items.potions

import persons.Person

/**
 * Health portion restores 10 points of health
 */

class HealthPotion extends AbstractPotion {
  var name: String = "Health Potion"
  override val points: Int = 10
  
  override def use(): Unit =
    println(s"$name consumed. Restored $points health points.")

}
