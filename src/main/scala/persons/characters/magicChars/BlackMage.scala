package cl.uchile.dcc
package persons.characters.magicChars


class BlackMage(name: String = "Black Mage") extends AbstractMagicCharacter(name) {
  var healthPoints: Int = 75
  var attackPoints: Int = 20
  var defensePoints: Int = 15
  var weight: Int = 20

  override val manaPoints: Int = 100

  override val attackType: String = "Magical"
  val role: String = "Black Mage"

}
