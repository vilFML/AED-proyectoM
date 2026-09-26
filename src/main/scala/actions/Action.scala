package cl.uchile.dcc
package actions

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
  def getActionName(): String
}
