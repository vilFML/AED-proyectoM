package cl.uchile.dcc
package items.potions

/**
 * Mana potion restores 10 mana points
 */

class ManaPotion extends AbstractPotion{
  var name: String = "Mana Potion"
  override val points: Int = 10

  override def use(): Unit =
    println(s"$name consumed. Restored $points mana points.")
}
