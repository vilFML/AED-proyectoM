package cl.uchile.dcc
package items.potions


/**
 * encapsulates potion stats
 */
abstract class AbstractPotion extends Consumable {
  /**
   * potion name
   */
  var name: String

  /**
   * points for effect
   */
  val points: Int

  /**
   * method for using
   */
  def use(): Unit =
    println(s"$name potion consumed.")
}
