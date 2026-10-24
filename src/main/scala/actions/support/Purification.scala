package cl.uchile.dcc
package actions.support

import controller.{Source, Target}

import exceptions.specializations.InvalidTargetException

/**
 * Action removes debuffs
 */
class Purification extends AbstractSupportAction {

  /**
   * has a name
   */
  override protected val name: String = "Purification"

  override val baseHeal: Double = 0.0
  
  val manaCost: Int = 10
  
  override def doAction(source: Source, target: Target): Unit =
    checkBasics(source, target)
    if (!target.isEnemy)
      throw new InvalidTargetException(s"${target.name} is not an enemy and cannot receive Purification")
    checkSpell(source, manaCost)
    source.spendMana(manaCost)
    target.receivePurification(this, source)
}
