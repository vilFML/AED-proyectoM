package cl.uchile.dcc
package persons.characters

import items.Item

class Rogue(name: String) extends AbstractCharacter(name){
  var healthPoints: Int = 50
  var attackPoints: Int = 35
  var defensePoints: Int = 5
  var weight: Int = 10

  override val attackType: String = "Physical"
  val role: String = "Rogue"

  var inventory: Set[Item] = Set[Item]()
}
