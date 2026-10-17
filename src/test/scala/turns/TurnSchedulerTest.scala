package cl.uchile.dcc
package turns

import persons.characters.Knight
import persons.characters.magicChars.{BlackMage, WhiteMage}

import munit.FunSuite

import scala.compiletime.uninitialized

class TurnSchedulerTest extends FunSuite {  
  private var scheduler: TurnScheduler = uninitialized
  private var pj: WhiteMage = uninitialized
  private var pj2: BlackMage = uninitialized
  private var pj3: Knight = uninitialized
  
  override def beforeEach(context: BeforeEach): Unit = {
    scheduler = new TurnScheduler
    pj = new WhiteMage("Moon")
    pj2 = new BlackMage("Andromeda")
    pj3 = new Knight("Thrall")
  }

  test("new turnScheduler has no units") {
    assertEquals(scheduler.getTotalManagedCharacters, 0)
  }

  test("turn scheduler can add units") {
    scheduler.addUnit(pj)
    assertEquals(scheduler.getTotalManagedCharacters, 1)
  }

  test("isInTurn is true for an added character") {
    scheduler.setInTurnUnit(pj)
    assertEquals(scheduler.isInTurn(pj), true)
  }

  test("isInTurn is false for a character that was never added") {
    assertEquals(scheduler.isInTurn(pj), false)
  }

  test("removed character is no longer in turn") {
    scheduler.setInTurnUnit(pj)
    assertEquals(scheduler.isInTurn(pj), true)
    scheduler.setInTurnUnit(pj2)
    assertEquals(scheduler.isInTurn(pj), false)
  }

  test("Turnscheduler asks every pj to calculate its max action points."){
    scheduler.addUnit(pj)
    scheduler.addUnit(pj2)

    val pj1MaxActionPoints: Float = pj.getMaxActionPoints
    val pj2MaxActionPoints: Float = pj2.getMaxActionPoints

    scheduler.calculateAllMaxActionBars()
  }

  test("TurnScheduler increases every pj action point by 20"):
    scheduler.addUnit(pj)
    scheduler.addUnit(pj2)

    scheduler.increaseActionBars(20f)

    assertEquals(pj.getCurrentActionPoints, 120f)
    assertEquals(pj2.getCurrentActionPoints, 120f)

  test("Turn scheduler considers there is no character in turn, returns None."):
    assertEquals(scheduler.getInTurnUnit, None)

  test("Turn scheduler changes character in turn."):
    assertEquals(scheduler.setInTurnUnit(pj),true)

  test("Turn scheduler doesnt change the in-turn character if already in turn."):
    assertEquals(scheduler.setInTurnUnit(pj), true)
    assertEquals(scheduler.setInTurnUnit(pj), false)

  test("When theres no action bar completed, turn scheduler gets an empty list"):
    val resultList = scheduler.getCompletedActionBarsUnits
    assert(resultList.isEmpty)

  test("List empty if theres no characters with completed action bar."):
    scheduler.addUnit(pj)

    val result: List[(String, Float)] =
      scheduler.getCompletedActionBarsUnits

    assert(result.isEmpty)

  test("Character with completed action bar appears in completed action bar list"):
    pj.updateActionBarCompletedStatus(true)
    scheduler.addUnit(pj)

    val result = scheduler.getCompletedActionBarsUnits

    assertEquals(result.length, 1)
    assertEquals(result.head._1, "Moon")


  test("Only PJ with completed action bars appear in completed actino bar list"):
    pj.updateActionBarCompletedStatus(true)

    scheduler.addUnit(pj)
    scheduler.addUnit(pj2)

    val result = scheduler.getCompletedActionBarsUnits

    assertEquals(result.length, 1)
    assertEquals(result.head._1, "Moon")


  test("Completed ActionBar list is ordered by AP remaining"):
    pj.updateActionBarCompletedStatus(true)
    pj2.updateActionBarCompletedStatus(true)
    pj3.updateActionBarCompletedStatus(true)

    pj.setCurrentActionPoints(30f)
    pj2.setCurrentActionPoints(90f)
    pj3.setCurrentActionPoints(50f)

    scheduler.addUnit(pj)
    scheduler.addUnit(pj2)
    scheduler.addUnit(pj3)

    val resultList = scheduler.getCompletedActionBarsUnits
    val names = resultList.map(_._1)
    val remainingAPs = resultList.map(_._2)

    assertEquals(names, List("Andromeda", "Thrall", "Moon"))
    assertEquals(remainingAPs, List(90f, 50f, 30f))
}


