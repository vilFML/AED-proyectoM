package cl.uchile.dcc
package actions

import actions.use.EquipWeapon

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer
import scala.compiletime.uninitialized

class EquipWeaponTest extends FunSuite {

  var action: EquipWeapon = uninitialized

  override def beforeEach(context: BeforeEach): Unit = {
    action = new EquipWeapon()
  }

  test("permitir acceder a lista de usables") {
    assertEquals(obtained = action.usables, expected = ArrayBuffer.empty[String])
  }

  test("permitir modificar lista de usables."){
    action.usables += "Espada"
    assertEquals(obtained = action.usables.length, expected = 1)
    assertEquals(obtained = action.usables.head, expected = "Espada")
  }
}
