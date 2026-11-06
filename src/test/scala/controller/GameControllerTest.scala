package cl.uchile.dcc
package controller

import actions.ofensives.Attack
import items.weapons.physical.Sword
import persons.Enemy
import persons.characters.Knight
import persons.characters.magicChars.BlackMage

import munit.FunSuite

import scala.compiletime.uninitialized

class GameControllerTest extends FunSuite {
  var controller: GameController = uninitialized
  var knight: Knight = uninitialized
  var enemy: Enemy = uninitialized
  var blackMage: BlackMage = uninitialized

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController
    knight = new Knight
    enemy = new Enemy
    blackMage = new BlackMage
    knight.equipWeapon(new Sword)
  }

  test("no unit in turn at start") {
    assertEquals(controller.getCurrentUnit, None)
  }

  test("advanceTurn puts a unit in turn") {
    controller.registerUnit(knight)
    controller.advanceTurn()
    assertEquals(controller.getCurrentUnit.map(_.name), Some("Knight"))
  }

  test("executeAction without unit in turn throws") {
    intercept[IllegalStateException] {
      controller.executeAction(new Attack, enemy)
    }
  }

  test("executeAction applies the effect") {
    controller.registerUnit(knight)
    controller.advanceTurn()
    controller.executeAction(new Attack, enemy)
    assertEquals(enemy.healthPoints, 63)
  }

  test("resetGame clears units and turn") {
    controller.registerUnit(knight)
    controller.advanceTurn()
    controller.resetGame()
    assertEquals(controller.getCurrentUnit, None)
  }

  test("available actions per unit") {
    assert(controller.getAvailableActions(blackMage).exists(_.getActionName == "Thunder"))
  }

}
