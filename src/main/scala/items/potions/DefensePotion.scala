package cl.uchile.dcc
package items.potions

class DefensePotion extends AbstractPotion{
  /**
   * potion name
   */
  var name: String = "Defense Potion"

  /**
   * 10 defense points
   */
  override val points: Int = 10

  /**
   * action use
   */
  override def use(): Unit =
    println(s"$name consumed. Gained $points of defense. ")

}
