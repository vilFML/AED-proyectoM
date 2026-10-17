package cl.uchile.dcc
package items.weapons

import items.Item

/**
 * Interface for weapons
 */
trait Weapon extends Item {
  /**
   * has a category : sword, bow, ...
   */
  val category: String

  /**
   * physical or magic attack
   */
  val dmgType: String

  /**
   * has attack points
   */
  var dmgPoints: Int

  /**
   * indicates the weapon's weight
   * @return number as weight
   */
  def getWeight: Float
}
