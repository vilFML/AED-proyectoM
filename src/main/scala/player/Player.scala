package cl.uchile.dcc
package player

import persons.Person


/**
 * Player trait represents any player
 */
trait Player {
  /**
   * A player has a set of active units
   */
  protected val units: Set[Person]

  /**
   * a player can get its amount of active units
   * @return number of alive units
   */
  def getUnitsSize: Option[Int]

  /**
   * player can be defeated or not
   * @return True: Defeated
   *         False: In active game
   */
  def getDefeated: Boolean
}
