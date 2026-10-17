package cl.uchile.dcc
package items.potions

import persons.Entity

class DefensePotion extends AbstractPotion{
  var name: String = "Defense Potion"

  override val points: Int = 10

  override def use(): Unit =
    println(s"$name consumed. Gained $points of defense. ")

}
