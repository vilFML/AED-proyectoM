package cl.uchile.dcc
package persons.characters


class Archer(name: String = "Archer") extends AbstractCharacter(name) {
  
  var healthPoints: Int = 50
  var attackPoints: Int = 15
  var defensePoints: Int = 5
  var weight: Int = 15

  override val attackType: String = "Physical"
  val role: String = "Archer"
}
