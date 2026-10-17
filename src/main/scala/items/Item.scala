package cl.uchile.dcc
package items

/**
 * Item interface:
 */
trait Item {

  /**
   * an item has name
   */
  var name: String

  /**
   * item has its use
   */
  def use(): Unit
}
