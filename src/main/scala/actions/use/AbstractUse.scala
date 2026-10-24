package cl.uchile.dcc
package actions.use

import actions.AbstractAction
import scala.collection.mutable.ArrayBuffer

abstract class AbstractUse extends AbstractAction {

  /**
   * has a name
   */
  override val name: String

  /**
   * action to use items requires a list of items
   */
  var usables: ArrayBuffer[String]

  /**
   * to deploy action
   * @return the name of the action
   */
  override def getActionName: String =
    name

  
}
