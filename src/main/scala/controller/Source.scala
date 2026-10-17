package cl.uchile.dcc
package controller

import actions.Action

/**
 * interface for action source
 */
trait Source {

  /**
   * delegates action's own method
   * @param action to do
   * @param target action pointed at
   */
  def doAction(action: Action, target: Target): Unit
}
