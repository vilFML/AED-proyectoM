package cl.uchile.dcc
package actions

abstract class AbstractAction extends Action {

  /**
   * has a name
   */
  override protected val name: String

  /**
   * method to deploy name
   */
  override def getActionName: String =
    name

}
