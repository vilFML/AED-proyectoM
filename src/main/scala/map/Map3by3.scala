package cl.uchile.dcc
package map

class Map3by3 extends Map {
  /**
   * This map is a 3 by 3 matrix of panels
   */
  override val board: Array[Array[Panel]] = ???
    
  /**
   * Map has a set of panels
   */
  override val panels: Set[Panel] = ???
  /**
   * map has adjacency of all panels in the map
   */
  override val adjacentPanels: Array[((Int, Int), List[Panel])] = ???

  /**
   * returns a panel in x,y position
   *
   * @param x coord
   * @param y coord
   * @return the panel in the x,y position
   */
  override def getPanel(x: Int, y: Int): Panel = ???
}
