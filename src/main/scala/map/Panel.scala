package cl.uchile.dcc
package map

import persons.Entity

/**
 * Trait represents a singular panel
 */
trait Panel {
  /**
   * Has x, y coordinates
   */
  val x: Int
  val y: Int

  /**
   * Coordinates are stored in a (x,y) tuple
   */
  val coords: Array[Int]

  /**
   * Panel has a set of units
   */
  protected val localUnits: Set[Entity]

  /**
   * Panel can output the unit it contains
   * @return set of units inside
   */
  def getLocalUnits: Set[Entity]

  /**
   * Panel outputs if a given panel is adjacent
   * @return true if adyacent
   */
  def isAdjacent(panel: Panel): Boolean
}
