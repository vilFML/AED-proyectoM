package cl.uchile.dcc
package controller

import turns.{TurnScheduler, TurnSchedulerTrait}

import cl.uchile.dcc.actions.Action
import cl.uchile.dcc.exceptions.GameException
import cl.uchile.dcc.persons.Entity

import scala.collection.mutable

/**
 * game controller
 */
class GameController {
  private var scheduler: TurnSchedulerTrait = new TurnScheduler
  private val units: mutable.Map[String, Entity] = mutable.Map()
  private val tickSize: Float = 10f
  private val maxTicks: Int = 10000

  /**
   * registers a unit
   * @param unit name has to be unique
   */
  def registerUnit(unit: Entity): Unit = {
    units(unit.name) = unit
    scheduler.addUnit(unit)
  }

  /**
   * get currently playing unit
   * @return unit
   */
  def getCurrentUnit: Option[Entity] = scheduler.getInTurnUnit

  /**
   * next unit in turn
   */
  def advanceTurn(): Unit = {
    var ready = scheduler.getCompletedActionBarsUnits
    var ticks = 0
    while (ready.isEmpty && units.nonEmpty && ticks < maxTicks) {
      scheduler.increaseActionBars(tickSize)
      ready = scheduler.getCompletedActionBarsUnits
      ticks += 1
    }
    if (ready.nonEmpty) {
      val next = units(ready.head._1)    // higher surplus first
      scheduler.setInTurnUnit(next)
      next.setCurrentActionPoints(0f)    // bar starts empty
      next.updateActionBarCompletedStatus(false)
    }
  }

  def getAvailableActions(unit: Entity): List[Action] =
    unit.getAvailableActions

  /**
   * in-turn unit executes action
   * @param action to execute
   * @param target pointed at
   */
  def executeAction(action: Action, target: Target): Boolean = {
    val source = getCurrentUnit.getOrElse(
      throw new IllegalStateException("No unit in turn"))
    try
      source.doAction(action, target)
      true
    catch
      case e: GameException =>
        println(s"Action failed: ${e.getMessage}")
        false
    }

  /**
   * start new game
   */
  def resetGame(): Unit =
    scheduler = new TurnScheduler
    units.clear()
}


