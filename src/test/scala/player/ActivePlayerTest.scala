package cl.uchile.dcc
package player

import munit.FunSuite

import scala.compiletime.uninitialized

class ActivePlayerTest extends FunSuite {
  var player: Player = uninitialized

  override def beforeEach(context: BeforeEach): Unit = {
    player = new ActivePlayer
  }

  test("A player starts with an empty set of units."):
    assertEquals(Some(0), player.getUnitsSize)


  test("Player with empty set of units is defeated."):
    assertEquals(player.getUnitsSize, Some(0))
}