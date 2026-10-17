package cl.uchile.dcc
package turns

import persons.Entity

import scala.collection.mutable.ListBuffer

/**
 * Controls game turn logic
 */
trait TurnSchedulerTrait {
  /**
   * add unit
   */
  def addUnit(character: Entity): Unit

  /**
   * remove unit
   */
  def removeUnit(character: Entity): Unit

  /**
   * get if pj is currently in its turn
   */
  def isInTurn(character: Entity): Boolean

  /**
   * to get the size of the in-turn character set
   *
   * @return
   */
  def getTotalManagedCharacters: Int

  /**
   * calculate every max action bar for in-turn pjs
   */
  def calculateAllMaxActionBars(): Unit

  /**
   * restart units action bars
   */
  def rebootActionBars(character: Entity): Unit

  /**
   * increase every action bar by a magnitude
   */
  def increaseActionBars(amount: Float): Unit

  /**
   * signal if a unit completed its action bar
   */
  def notifyCompletedActionBar(character: Entity): Unit

  /**
   * output units with completed action bars
   * ordered by descending surplus
   * @return a list to store order
   */
  def getCompletedActionBarsUnits: List[(String, Float)]

  /**
   * output the unit in turn
   * gives access to the object
   */
  def getInTurnUnit: Option[Entity]

  /**
   * can modify the currently in-turn character
   * returns true if changed pj
   */
  def setInTurnUnit(character: Entity): Boolean
}
