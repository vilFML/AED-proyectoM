package cl.uchile.dcc
package map

import persons.Person

import scala.collection.mutable.ArrayBuffer

/**
 * the class of a certain panel
 */
class singularPanel {
  /**
   * has coordinates
   */
  val x: Int = 0
  val y: Int = 0

  /**
   * (x,y) array
   */
  val coords: Array[Int] = Array[Int](x,y)

  /**
   * Panel has units inside
   * initially no units
   */
  private var localUnits: ArrayBuffer[Person] = ArrayBuffer[Person]()

  /** Returns a set with pjs inside the current panel
   *
   * @return set with pjs
   */
  def getLocalUnits: ArrayBuffer[Person] = {
    localUnits
  }
  
  def isAdjacent: Boolean = ???
}
