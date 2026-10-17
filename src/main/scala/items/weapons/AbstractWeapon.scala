package cl.uchile.dcc
package items.weapons

/**
 * encapsulates the common methods for every weapon
 */
abstract class AbstractWeapon extends Weapon {
  /**
   * every weapon has weight
   */
  protected var weaponWeight: Float

  /**
   * weapon outputs its weight
   *  @return number as weight
   */
  override def getWeight: Float = weaponWeight

  /**
   * weapon use is an attack
   */
  override def use(): Unit =
    println(s"Attacking with $name for $dmgPoints.")
}
