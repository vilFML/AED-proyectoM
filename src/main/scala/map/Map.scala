package cl.uchile.dcc
package map

/**
 * Trait represents the general game map
 */
trait Map {
  /**
   * Map is a matrix of panels
   */
  val board: Array[Array[Panel]]

  /**
   * Map has a set of panels
   */
  val panels: Set[Panel]

  /**
   * map has adjacency of all panels in the map
   */
  val adjacentPanels: Array[((Int,Int), List[Panel])]

  /**
   * returns a panel in x,y position
   * @param x coord
   * @param y coord
   * @return the panel in the x,y position
   */
  def getPanel(x: Int, y: Int): Panel
}
