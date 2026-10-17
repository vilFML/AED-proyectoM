package cl.uchile.dcc
package actions.ofensives

import controller.{Source, Target}

/**
 * a thunder cast
 */
class Thunder extends AbstractOffensiveAction {

  /**
   * has a name
   */
  override protected val name: String = "Thunder"

  override val basePower: Double = 30.0

  override def doAction(source: Source, target: Target): Unit =
    target.receiveThunder(this, source)
}
