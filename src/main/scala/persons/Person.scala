package cl.uchile.dcc
package persons

import map.Panel

/**
 * Person trait
 * 
 */

/* PJ has
1. name
2. health points
3. defense points
4. weight
 */

trait Person {
  val name: String
  var healthPoints: Int
  var attackPoints: Int
  var defensePoints: Int

  /**
   * weight determines speed (TODO)
   */
  var weight: Int
  var isHostile: Boolean

  /**
   * PJ has action points
   */
  val maxActionPoints: Int

  /**
   * the current action points
   */
  val currentActionPoints: Int

  /**
   * calculate the max action points for the PJ
   */
  def calculateMaxActionPoints(): Int
}
