package cl.uchile.dcc
package actions

import controller.{Source, Target}

import cl.uchile.dcc.exceptions.specializations.{DefeatedUnitException, InsufficientManaException, MissingWeaponException}

abstract class AbstractAction extends Action {

  /**
   * has a name
   */
  override protected val name: String

  /**
   * method to deploy name
   */
  override def getActionName: String = name

  /**
   * source and target must be alive
   * @param source
   * @param target
   */
  protected def checkBasics(source: Source, target: Target): Unit = {
    if (source.isAlive == false)
      throw new DefeatedUnitException(s"${source.name} is defeated and cannot act")

    if(target.isAlive == false)
      throw new DefeatedUnitException(s"${target.name} is defeated and cannot receive actions")
  }

  /**
   * spells need magical weapon and enough mana
   * @param source
   * @param manaCost
   */
  protected def checkSpell(source: Source, manaCost: Int): Unit = {
    if(source.hasMagicalWeapon == false)
      throw new MissingWeaponException(s"${source.name} needs a magical weapon to cast spells")
      
    if(source.canSpendMana(manaCost)==false)
      throw new InsufficientManaException(s"${source.name} needs $manaCost mana to cast this spell")
  }
}
