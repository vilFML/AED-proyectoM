package cl.uchile.dcc
package map

import munit.FunSuite

import scala.compiletime.uninitialized

class singularPanelTest extends FunSuite {
  var panel: singularPanel = uninitialized
  var panel2: singularPanel = uninitialized

  override def beforeEach(context: BeforeEach): Unit ={
    panel = new singularPanel
    panel2 = new singularPanel(1,1)

  }

  test("New panel has no units inside."):
    assertEquals(0, panel.getLocalUnits.size)

  test("Newly created panel has x coordinate in 0"):
    assertEquals(panel.x, 0)
  test("Newly created panel has y coordinate in 0"):
    assertEquals(panel.y, 0)

  test("Panel initialization can define a non-0 x coordinate"):
    assertNotEquals(panel2.x, 0)
  test("Panel initialization can define a non-0 x coordinate"):
    assertNotEquals(panel2.y, 0)

  test("Panel in (1.1) is adjacent to panel in (0.0)"):
    assertEquals(true,panel.isAdjacent(panel2))
}
