package cl.uchile.dcc
package map

import persons.Person

/**
 * the class of a certain panel
 */
class singularPanel(inX: Int = 0, inY: Int = 0) extends Panel{
  /**
   * has coordinates
   */
  val x: Int = inX
  val y: Int = inY

  /**
   * stores (x,y) array
   */
  val coords: Array[Int] = Array[Int](x,y)

  /**
   * Panel has units inside
   * starts empty
   */
  protected val localUnits: Set[Person] = Set[Person]()

  /**
   * Returns a set with pjs inside the current panel
   * @return set with pjs
   */
  def getLocalUnits: Set[Person] = {
    localUnits
  }
  
  override def isAdjacent(panel2: Panel): Boolean = {
    val x1: Int = this.x
    val y1: Int = this.y

    val x2: Int = panel2.x
    val y2: Int = panel2.y

    var res: Boolean = false            //defaults to not adjacent

    /**
     * if cooordinates are 1 tile apart: adjacent
     */
    if ( ((x2-x1).abs <= 1) && (y2-y1).abs <= 1 ){
      res = true
    }
    res
  }

}
