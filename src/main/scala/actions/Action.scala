package cl.uchile.dcc
package actions

import persons.Entity

import cl.uchile.dcc.controller.{Source, Target}

/**
 * Trait represent any action
 */
trait Action {
  /**
   * has a name
   */
  protected val name: String

  /**
   * method to deploy name
   */
  def getActionName: String

  /**
   * action resolves its invoker and its target
   * @param source entity doing
   * @param target affected 
   */
  def doAction(source: Source, target: Target): Unit
}
