package cl.uchile.dcc
package actions.use

import controller.{Source, Target}
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

  /**
   * dispatch call
   * @param source entity doing
   * @param target affected
   */
  override def doAction(source: Source, target: Target): Unit = {
    checkBasics(source, target)
    target.receiveConsumePotion(this, source)
  }
}
