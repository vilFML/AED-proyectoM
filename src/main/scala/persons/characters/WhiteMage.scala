package cl.uchile.dcc
package persons.characters

import items.Item

class WhiteMage(name: String) extends AbstractCharacter(name){
  var healthPoints: Int = 75
  var attackPoints: Int = 5
  var defensePoints: Int = 30
  var weight: Int = 15

  override val attackType: String = "Magical"
  val role: String = "White Mage"

  var inventory: Set[Item] = Set[Item]()

}
