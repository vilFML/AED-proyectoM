package cl.uchile.dcc
package items.weapons.physical

class Sword(var name: String = "Sword") extends AbstractPhysicalWeapon{
  
  /**
   * immutable sword category
   */
  override val category: String = "Sword"

  /**
   * placeholder damage
   */
  var dmgPoints: Int = 30

  /**
   * has high weight
   */
  protected var weaponWeight: Float = 10.0
  
}
