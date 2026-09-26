package cl.uchile.dcc
package persons.characters

import items.Item

class BlackMage(name: String) extends AbstractCharacter(name) {
  var healthPoints: Int = 75
  var attackPoints: Int = 20
  var defensePoints: Int = 15
  var weight: Int = 20

  override val attackType: String = "Magical"
  val role: String = "Black Mage"

  var inventory: Set[Item] = Set[Item]()
}
