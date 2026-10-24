package cl.uchile.dcc
package persons.characters

import actions.{Action, Move}

import cl.uchile.dcc.actions.ofensives.Attack
import cl.uchile.dcc.actions.use.{ConsumePotion, EquipWeapon}

/**
 * 
 * @param name assign name when created
 */
class Knight(name: String = "Knight") extends AbstractCharacter(name) {

  var healthPoints: Int = 100
  var attackPoints: Int = 25
  var defensePoints: Int = 20
  var weight: Int = 50

  override val attackType: String = "Physical"
  val role: String = "Knight"

  override def attackPower: Double = attackPoints * 1.5

  override protected val availableActions: List[Action] =
    List(new Attack, new Move, new EquipWeapon, new ConsumePotion)

  /**
   * can only wield swords
   */
  override val allowedWeaponCategories: Set[String] = Set("Sword")
}
