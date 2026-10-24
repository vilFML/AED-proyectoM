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

  override val basePower: Double = 30.0
  
  val manaCost: Int = 15

  override def doAction(source: Source, target: Target): Unit = {
    checkBasics(source, target)
    checkSpell(source, manaCost)
    source.spendMana(manaCost)
    target.receiveThunder(this, source)
  }
}
