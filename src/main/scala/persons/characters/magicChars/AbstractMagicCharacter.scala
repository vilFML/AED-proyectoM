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

  /**
   * tracks spent mana by pj
   */
  private var spentMana: Int = 0

  /**
   * calculates simple difference
   * @return mana surplus
   */
  def currentMana: Int =
    manaPoints - spentMana

  /**
   * check if has mana to spend
   * @param amount
   * @return true if allowed
   */
  override def canSpendMana(amount: Int): Boolean =
    currentMana >= amount

  /**
   * use mana and add to the tracked spent mana
   * @param amount to use
   */
  override def spendMana(amount: Int): Unit =
    spentMana += amount

}
