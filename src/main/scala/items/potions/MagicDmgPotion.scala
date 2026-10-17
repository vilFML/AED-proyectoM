package cl.uchile.dcc
package items.potions

import persons.Person

class MagicDmgPotion extends AbstractPotion{
  var name: String = "Magic Damage Potion"

  override val points: Int = 10

  override def use(): Unit =
    println(s"$name consumed. Increased $points of magic damage.")
}
