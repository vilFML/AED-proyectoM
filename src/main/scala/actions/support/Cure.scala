package cl.uchile.dcc
package actions.support

import controller.{Source, Target}

/**
 * Heal action
 */
class Cure extends AbstractSupportAction {

  /**
   * has a name
   */
  override protected val name: String = "Cure"

  override val baseHeal: Double = 30.0

  override def doAction(source: Source, target: Target): Unit =
    target.receiveCure(this, source)
}
