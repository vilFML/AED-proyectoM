package cl.uchile.dcc
package actions

import actions.ofensives.{Attack, Thunder}
import actions.support.Cure
import items.weapons.magical.{Rod, Wand}
import items.weapons.physical.Sword
import persons.Enemy
import persons.characters.Knight
import persons.characters.magicChars.{BlackMage, WhiteMage}

import munit.FunSuite

import scala.compiletime.uninitialized

class DoubleDispatchTest extends FunSuite{
  var knight: Knight = uninitialized
  var blackMage: BlackMage = uninitialized
  var whiteMage: WhiteMage = uninitialized
  var enemy: Enemy = uninitialized

  override def beforeEach(context: BeforeEach): Unit = {
    knight = new Knight
    blackMage = new BlackMage
    whiteMage = new WhiteMage
    enemy = new Enemy
    
    knight.equipWeapon(new Sword())
    blackMage.equipWeapon(new Rod())
    whiteMage.equipWeapon(new Wand())
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
