package cl.uchile.dcc
package actions.use

import actions.use.AbstractUse

import cl.uchile.dcc.controller.{Source, Target}

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
  
  override def doAction(source: Source, target: Target): Unit = {
    checkBasics(source, target)
    target.receiveConsumePotion(this, source)
  }
}
