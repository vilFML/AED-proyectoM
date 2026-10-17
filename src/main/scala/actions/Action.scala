package cl.uchile.dcc
package actions

import persons.Person

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
   * main method for interaction
   */
  def doAction(target: Person): Unit
}
