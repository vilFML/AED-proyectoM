package cl.uchile.dcc
package items.potions

/**
 * Health portion restores 10 points of health
 */

class HealthPotion extends AbstractPotion {
  /**
   * potion name
   */
  var name: String = "Health Potion"

  /**
   * points to heal
   */
  override val points: Int = 10

  /**
   * use method
   */
  override def use(): Unit =
    println(s"$name consumed. Restored $points health points.")

}
