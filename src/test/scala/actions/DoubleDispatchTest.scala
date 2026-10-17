package cl.uchile.dcc
package actions

import cl.uchile.dcc.actions.ofensives.{Attack, Thunder}
import cl.uchile.dcc.actions.support.Cure
import cl.uchile.dcc.persons.Enemy
import cl.uchile.dcc.persons.characters.Knight
import cl.uchile.dcc.persons.characters.magicChars.{BlackMage, WhiteMage}
import munit.FunSuite

import scala.compiletime.uninitialized

class DoubleDispatchTest extends FunSuite{
  var knight: Knight = uninitialized
  var blackMage: BlackMage = uninitialized
  var whiteMage: WhiteMage = uninitialized
  var enemy: Enemy = uninitialized

  override def beforeEach(context: BeforeEach): Unit = {
    knight = new Knight;
    blackMage = new BlackMage
    whiteMage = new WhiteMage;
    enemy = new Enemy
  }

  // Different source, same action, same target
  test("Attack damage depends on the source") {
    knight.doAction(new Attack, enemy)
    assertEquals(enemy.healthPoints, 63)
    val enemy2 = new Enemy
    blackMage.doAction(new Attack, enemy2)
    assertEquals(enemy2.healthPoints, 80)
  }

  // Same source, same action, different target
  test("Attack damage depends on the target") {
    knight.doAction(new Attack, blackMage)
    assertEquals(blackMage.healthPoints, 33)
  }

  // Same source, different action, same target
  test("Thunder and Attack differ for the same source and target") {
    blackMage.doAction(new Thunder, enemy)
    assertEquals(enemy.healthPoints, 40)
  }

  test("Cure heals the target") {
    knight.healthPoints = 50
    whiteMage.doAction(new Cure, knight)
    assertEquals(knight.healthPoints, 100)
  }

}
