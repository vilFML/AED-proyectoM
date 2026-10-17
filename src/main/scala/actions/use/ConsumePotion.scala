package cl.uchile.dcc
package actions.use

import actions.use.AbstractUse

import scala.collection.mutable.ArrayBuffer

class ConsumePotion extends AbstractUse {

  /**
   * has a name
   */
  override val name: String = "Consume Potion"
  /**
   * action to use items requires a list of items
   */
  var usables: ArrayBuffer[String] = ArrayBuffer.empty[String]
}
