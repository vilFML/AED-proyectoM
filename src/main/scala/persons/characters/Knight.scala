package cl.uchile.dcc
package persons.characters

import items.Item

/**
 * 
 * @param name: assign name when created
 *              
 * inventory empty when instantiated
 */

class Knight(name: String) extends AbstractCharacter(name) {
  var healthPoints: Int = 100
  var attackPoints: Int = 25
  var defensePoints: Int = 20
  var weight: Int = 50

  override val attackType: String = "Physical"
  val role: String = "Knight"
  
  var inventory: Set[Item] = Set[Item]()
}
