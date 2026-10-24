package cl.uchile.dcc
package actions.ofensives

import cl.uchile.dcc.controller.{Source, Target}
import cl.uchile.dcc.exceptions.specializations.MissingWeaponException

/**
 * represents an attacking action
 */
class Attack extends AbstractOffensiveAction {
  /**
   * has a name
   */
  override protected val name: String = "Attack"

  /**
   * Points to attack
   * defaults to 20.0
   */
  override val basePower: Double = 20.0

  /**
   * dispatch action,
   * performs checks
   * @param source entity doing
   * @param target affected
   */
  override def doAction(source: Source, target: Target): Unit = {
    checkBasics(source, target)
    if(source.hasWeapon == false)
      throw new MissingWeaponException(s"${source.name} need a weapon to attack")
      
    target.receiveAttack(this, source)
  }

}