package cl.uchile.dcc
package items.weapons.magical

class Rod(var name: String = "Rod") extends AbstractMagicalWeapon {

  /**
   * immutable rod category
   */
  override val category: String = "Rod"

  /**
   * placeholder damage
   */
  var dmgPoints: Int = 30

  /**
   * has medium weight
   */
  protected var weaponWeight: Float = 5.0
}
