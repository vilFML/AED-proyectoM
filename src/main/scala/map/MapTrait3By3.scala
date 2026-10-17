package cl.uchile.dcc
package map

/**
 * Class is a 3 by 3 matrix of panels
 */
class MapTrait3By3 extends MapTrait {

  /**
   * creating a 3by3 board
   *
   *   -1|
   *    0|
   *    1|
   * y\x |-1|0|1
   */
  protected val board: Array[Array[Panel]] = Array.ofDim[Panel](3, 3)
    for {
      i <- 0 until 3
      j <- 0 until 3
    } board (i)(j) = new singularPanel(i,j)

  /**
   * method to access a panel
   * @param x coordinate
   * @param y coordinate
   * @return panel in (x,y) position
   */
  def getPanel(x: Int, y: Int): Panel = board(x)(y)
}
