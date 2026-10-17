package cl.uchile.dcc
package actions.support

import controller.{Source, Target}

/**
 * Action removes debuffs
 */
class Purification extends AbstractSupportAction {

  /**
   * has a name
   */
  override protected val name: String = "Purification"

  override val baseHeal: Double = 0.0
  
  override def doAction(source: Source, target: Target): Unit =
    target.receivePurification(this, source)
}
