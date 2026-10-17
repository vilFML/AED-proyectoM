package cl.uchile.dcc
package items.weapons.physical

class Bow(var name: String = "Bow") extends AbstractPhysicalWeapon {
  /**
   * immutable bow category
   */
  override val category: String = "Bow"

  /**
   * placeholder damage
   */
  var dmgPoints = 20

  /**
   * has medium weight
   */
  protected var weaponWeight: Float = 5.0
}
