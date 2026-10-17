package cl.uchile.dcc
package actions.ofensives

import cl.uchile.dcc.controller.{Source, Target}

/**
 * represents an attacking action
 */
class Attack extends AbstractOffensiveAction {
  /**
   * has a name
   */
  override protected val name: String = "Attack"

  /**
   * Points to attack
   * defaults to 20.0
   */
  override val basePower: Double = 20.0

  /**
   * dispatch action
   * @param source entity doing
   * @param target affected
   */
  override def doAction(source: Source, target: Target): Unit =
    target.receiveAttack(this, source)

}