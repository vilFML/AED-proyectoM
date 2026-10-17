package cl.uchile.dcc
package actions.use

import actions.use.AbstractUse

import scala.collection.mutable.ArrayBuffer

class EquipWeapon extends AbstractUse {

  /**
   * has a name
   */
  override val name: String = "EquipWeapon"
  /**
   * action to use items requires a list of items
   * starts empty
   */
  var usables: ArrayBuffer[String] = ArrayBuffer.empty[String]
}
