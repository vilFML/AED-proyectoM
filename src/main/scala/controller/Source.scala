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
  
  /**
   * source gives respective points by role
   * @return
   */
  def attackPower: Double

  def magicPower: Double

  def healPower: Double
}
