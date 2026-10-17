package cl.uchile.dcc
package persons

import munit.FunSuite

import scala.compiletime.uninitialized

class EnemyTest extends FunSuite {
  var enemy: Enemy = uninitialized

  override def beforeEach(context: BeforeEach): Unit = {
    enemy = new Enemy
  }

  test("Enemy can output its weight"):
    assertEquals(enemy.getWeight, 30f)

  test("Enemy is always hostile."):
    assertEquals(enemy.getHostility, true)

  test("Enemy gets its max action points"):
    assertEquals(enemy.getMaxActionPoints, 70f)

}
