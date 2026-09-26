package cl.uchile.dcc
package map

import cl.uchile.dcc.persons.Person

import scala.collection.mutable.ArrayBuffer

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
   * Stores in a (x,y) tuple
   */
  val coords: Array[Int]

  /**
   * Panel has units inside of it
   */
  var localUnits: ArrayBuffer[Person]

  /** Returns the set of characters inside the panel
   * @return
   */
  def getLocalUnits: Set[Person]

  /**
   * returns True if is adjacent to a panel
   * @return
   */
  def isAdjacent: Boolean
}
