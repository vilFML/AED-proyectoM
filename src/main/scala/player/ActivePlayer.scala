package cl.uchile.dcc
package player

import persons.Entity

/**
 * an in-game player
 */
class ActivePlayer extends Player {

  /**
   * Starts with an empty set of units
   */
  override val units: Set[Entity] = Set[Entity]()
    
  /**
   * a player can get its amount of active units
   *
   * @return number of alive units
   */
  override def getUnitsSize: Option[Int] = {
    Some(units.size)
  }


  override def getDefeated: Boolean = {
    var res = false
    if (this.getUnitsSize.contains(0)) {
      println("Player defeated.")
      res = true
    }
    else{
      println("Player in-game.")
    }
    res
  }

}
