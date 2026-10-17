package cl.uchile.dcc
package actions.ofensives

import actions.AbstractAction

import cl.uchile.dcc.controller.{Source, Target}

/**
 * encapsulates damage dealing action
 */
abstract class AbstractOffensiveAction extends AbstractAction {

  /**
   * damage to give
   */
  val basePower: Double
}
