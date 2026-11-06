package cl.uchile.dcc
package actions.ofensives

import controller.{Source, Target}

/**
 * a thunder cast
 */
class Thunder extends AbstractOffensiveAction {

  /**
   * has a name
   */
  override protected val name: String = "Thunder"

  /**
   * has a power for attack
   */
  override val basePower: Double = 30.0

  /**
   * costs certain mana points
   */
  val manaCost: Int = 15

  /**
   * double dispatch for action call, 
   * checks units, spells & mana before dispatching
   *
   * @param source entity doing
   * @param target affected
   */
  override def doAction(source: Source, target: Target): Unit = {
    checkBasics(source, target)
    checkSpell(source, manaCost)
    source.spendMana(manaCost)
    target.receiveThunder(this, source)
  }
}
