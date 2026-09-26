package cl.uchile.dcc
package actions

import munit.FunSuite

import scala.compiletime.uninitialized

class MoveTest extends FunSuite {

  var action: Action = uninitialized

  override def beforeEach(context: BeforeEach): Unit = {
    action = new Move()
  }

  test("move invoked."){
    assertEquals(obtained = action.getActionName(), expected = "Move")
  }
}
