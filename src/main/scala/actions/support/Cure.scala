package cl.uchile.dcc
package actions.support

import controller.{Source, Target}

import exceptions.specializations.InvalidTargetException

/**
 * Heal action
 */
class Cure extends AbstractSupportAction {

  /**
   * has a name
   */
  override protected val name: String = "Cure"

  override val baseHeal: Double = 30.0
  
  val manaCost: Int = 10
  
  override def doAction(source: Source, target: Target): Unit =
    checkBasics(source, target)
    if (target.isEnemy)
      throw new InvalidTargetException(s"${target.name} is an enemy and cannot receive Cure")
    checkSpell(source, manaCost)
    source.spendMana(manaCost)
    target.receiveCure(this, source)
}
