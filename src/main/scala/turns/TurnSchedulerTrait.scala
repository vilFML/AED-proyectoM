package cl.uchile.dcc
package turns

import persons.Person

/**
 * Controls game turn logic
 */
trait TurnSchedulerTrait {
  /**
   * add unit
   */
  def addUnit(character: Person): Unit

  /**
   * remove unit
   */
  def removeUnit(character: Person): Unit

  /**
   * get every max action bars
   */

  /**
   * to get the size of the in-turn character set
   * @return
   */
  def size: Int

  def getMaxActionBars(): Unit

  /**
   * restart units action bars
   */
  def rebootActionBars(character: Person): Unit

  /**
   * increase every action bar by a magnitude
   */
  def increaseActionBars(amount: Int): Unit

  /**
   * signal if a unit completed its action bar
   */
  def notifyCompletedActionBar(): Unit

  /**
   * output units with completed action bars
   *  order: action bar surplus after completing
   */
  def completedActionBarsUnits(): Unit

  /**
   * output the unit in turn
   */
  def outputUnitInTurn(): String
}
