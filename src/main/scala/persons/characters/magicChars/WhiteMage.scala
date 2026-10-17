package cl.uchile.dcc
package persons.characters.magicChars

class WhiteMage(name: String = "White Mage") extends AbstractMagicCharacter(name) {

  var healthPoints: Int = 75
  var attackPoints: Int = 5
  var defensePoints: Int = 30
  var weight: Int = 15

  override val manaPoints: Int = 100

  override val attackType: String = "Magical"
  val role: String = "White Mage"

}
