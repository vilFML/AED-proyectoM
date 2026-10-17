package cl.uchile.dcc
package persons

/**
 * Person interface
 *  represent every game unit
 */

trait Person {
  /**
   * has a name
   */
  def name: String

  /**
   * has health points
   */
  var healthPoints: Int

  /**
   * has attack points
   */
  var attackPoints: Int

  /**
   * has defense points
   */
  var defensePoints: Int
  
  /**
   * can be hostile
   */
  def getHostility: Boolean

  /**
   * outputs its weight
   * @return float as weight
   */
  def getWeight: Float

  /**
   * calculate the max action points for the PJ
   */
  def calculateMaxActionPoints(): Unit

  /**
   * outputs its max action points stored
   * @return a float with the pj's max action points
   */
  def getMaxActionPoints: Float

  /**
   * pj outputs its current action points stored
   * @return float as the action points
   */
  def getCurrentActionPoints: Float

  /**
   * person can modify its own action points
   * @param amount is the new action points value
   */
  def setCurrentActionPoints(amount: Float): Unit

  /**
   * pj can refill its action bar
   */
  def rebootActionBar(): Unit

  /**
   * add an amount to the current action points
   */
  def increaseActionPoints(amount: Float): Unit

  /**
   * communicates if the pj completed its action bar
   * @return true if its bar is completed
   */
  def isActionBarCompleted: Boolean

  /**
   * updates the tracked status of action bar completion
   * @param newStatus the new status
   * @return true if changed, false if not modified
   */
  def updateActionBarCompletedStatus(newStatus: Boolean): Boolean
}
