package cl.uchile.dcc
package items

/**
 * Item interface:
 * has name, owner and weight
 * can be used
 */
trait Item {
  var name: String
  val owner: persons.Person
  val weight: Int
  
  def use(): Unit
}
