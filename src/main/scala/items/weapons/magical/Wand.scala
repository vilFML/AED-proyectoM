package cl.uchile.dcc
package items.weapons.magical

class Wand(var name: String = "Wand") extends AbstractMagicalWeapon {

  /**
   * immutable wand category
   */
  override val category: String = "Wand"

  /**
   * placeholder damage
   */
  var dmgPoints: Int = 40

  /**
   * has low weight
   */
  protected var weaponWeight: Float = 2.5
}
