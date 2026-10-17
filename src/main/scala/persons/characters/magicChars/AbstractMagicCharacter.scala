package cl.uchile.dcc
package persons.characters.magicChars

import persons.characters.AbstractCharacter

/**
 * sub-specialization of playable character
 */
abstract class AbstractMagicCharacter(name: String) extends AbstractCharacter(name) {
  /**
   * has mana points
   */
  val manaPoints: Int
}
