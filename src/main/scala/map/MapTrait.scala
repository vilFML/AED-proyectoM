package cl.uchile.dcc
package map

/**
 * Trait represents the general game map
 */
trait MapTrait {
  /**
   * Map is a matrix of panels
   */
  protected val board: Array[Array[Panel]]

  /**
   * method to access a panel
   *
   * @param x coordinate
   * @param y coordinate
   * @return panel in (x,y) position
   */
  def getPanel(x: Int, y: Int): Panel
}
