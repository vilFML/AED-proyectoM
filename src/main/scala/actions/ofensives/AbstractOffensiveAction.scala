package cl.uchile.dcc
package actions.ofensives

import actions.AbstractAction

/**
 * encapsulates damage dealing action
 */
abstract class AbstractOffensiveAction extends AbstractAction {

  /**
   * damage to give
   */
  val basePower: Double
}
