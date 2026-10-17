package cl.uchile.dcc
package actions

import controller.{Source, Target}

class Move extends AbstractAction {

  /**
   * has a name
   */
  override protected val name: String = "Move"


  override def doAction(source: Source, target: Target): Unit =
    target.receiveMove(this, source)
}
