package cl.uchile.dcc
package persons.characters

/**
 * 
 * @param name assign name when created
 */
class Knight(name: String = "Knight") extends AbstractCharacter(name) {

  var healthPoints: Int = 100
  var attackPoints: Int = 25
  var defensePoints: Int = 20
  var weight: Int = 50

  override val attackType: String = "Physical"
  val role: String = "Knight"

}
