package cl.uchile.dcc
package items.weapons.physical

class Dagger(var name: String = "Dagger") extends AbstractPhysicalWeapon {

  /**
   * immutable dagger category
   */
  override val category: String = "Dagger"

  /**
   * placeholder damage
   */
  var dmgPoints: Int = 40

  /**
   * has low weight
   */
  protected var weaponWeight: Float = 1.0
  
}
