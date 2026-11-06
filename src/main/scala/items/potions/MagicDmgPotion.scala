package cl.uchile.dcc
package items.potions

class MagicDmgPotion extends AbstractPotion{

  /**
   * potion name
   */
  var name: String = "Magic Damage Potion"

  /**
   * points to gain
   */
  override val points: Int = 10

  /**
   * method for using
   */
  override def use(): Unit =
    println(s"$name consumed. Increased $points of magic damage.")
}
