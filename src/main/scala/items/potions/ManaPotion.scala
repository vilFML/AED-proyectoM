package cl.uchile.dcc
package items.potions

/**
 * Mana potion restores 10 mana points
 */

class ManaPotion extends AbstractPotion{

  /**
   * potion name
   */
  var name: String = "Mana Potion"

  /**
   * mana points to restore
   */
  override val points: Int = 10

  /**
   * restoring action
   */
  override def use(): Unit =
    println(s"$name consumed. Restored $points mana points.")
}
