package cl.uchile.dcc
package actions

import actions.ofensives.Thunder

import munit.FunSuite

import scala.compiletime.uninitialized

class ThunderTest extends FunSuite {
  var action: Action = uninitialized

  override def beforeEach(context: BeforeEach): Unit = {
    action = new Thunder()
  }

  test("Thunder invoked"){
    assertEquals(obtained = action.getActionName, expected = "Thunder")
  }
}
