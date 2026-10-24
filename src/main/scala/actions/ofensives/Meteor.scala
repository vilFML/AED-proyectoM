package cl.uchile.dcc
package actions.ofensives

import controller.{Source, Target}

/**
 * represens a casting Metheor action
 */
class Meteor extends AbstractOffensiveAction {
  /**
   * has a name
   */
  override protected val name: String = "Meteor"

  override val basePower: Double = 40.0
  
  val manaCost: Int = 30

  override def doAction(source: Source, target: Target): Unit = {
    checkBasics(source, target)
    checkSpell(source, manaCost)
    source.spendMana(manaCost)
    target.receiveMeteor(this, source)
  }
}
