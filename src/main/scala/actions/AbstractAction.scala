package cl.uchile.dcc
package actions

import controller.{Source, Target}

abstract class AbstractAction extends Action {

  /**
   * has a name
   */
  override protected val name: String

  /**
   * method to deploy name
   */
  override def getActionName: String =
    name

  override def doAction(source: Source, target: Target): Unit = ???
  
}
