package cl.uchile.dcc
package actions.ofensives

import controller.{Source, Target}

/**
 * represents a casting Meteor action
 */
class Meteor extends AbstractOffensiveAction {
  /**
   * has a name
   */
  override protected val name: String = "Meteor"

  /**
   * has a power for attack
   */
  override val basePower: Double = 40.0

  /**
   * costs certain mana points
   */
  val manaCost: Int = 30

  /**
   * double dispatch for action call, 
   * checks units, spells & mana before dispatching
   * @param source entity doing
   * @param target affected
   */
  override def doAction(source: Source, target: Target): Unit = {
    checkBasics(source, target)
    checkSpell(source, manaCost)
    source.spendMana(manaCost)
    target.receiveMeteor(this, source)
  }
}
