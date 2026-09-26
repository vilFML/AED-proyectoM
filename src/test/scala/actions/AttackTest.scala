package cl.uchile.dcc
package actions

import munit.FunSuite

import scala.compiletime.uninitialized

class AttackTest extends FunSuite {

  var action: Action = uninitialized

  override def beforeEach(context: BeforeEach): Unit = {
    action = new Attack()
  }

  test("attack invoked.") {
    assertEquals(obtained = action.getActionName(), expected = "Attack")
  }
}
