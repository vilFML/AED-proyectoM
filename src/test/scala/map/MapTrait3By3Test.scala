package cl.uchile.dcc
package map

import munit.FunSuite

import scala.compiletime.uninitialized

class MapTrait3By3Test extends FunSuite {
  var testBoard: MapTrait = uninitialized

  override def beforeEach(context: BeforeEach): Unit ={
    testBoard = new MapTrait3By3
  }

  test("Panel can output the (0.0) panel"):
    val middlePanel = testBoard.getPanel(0,0)
    assertEquals(middlePanel.x,0)
}
