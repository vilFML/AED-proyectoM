package cl.uchile.dcc
package persons.characters

import actions.ofensives.Attack
import actions.use.{ConsumePotion, EquipWeapon}
import actions.{Action, Move}

/**
 * @param name assign name to pj when created
 */
class Knight(name: String = "Knight") extends AbstractCharacter(name) {

  /**
   * each stat for role
   */
  var healthPoints: Int = 100
  var attackPoints: Int = 25
  var defensePoints: Int = 20
  var weight: Int = 50

  /**
   * attackType per role
   */
  override val attackType: String = "Physical"

  /**
   * role name
   */
  val role: String = "Knight"

  /**
   * role attack power
   *  @return
   */
  override def attackPower: Double = attackPoints * 1.5

  /**
   * available actions per role
   */
  override protected val availableActions: List[Action] =
    List(new Attack, new Move, new EquipWeapon, new ConsumePotion)

  /**
   * can only wield swords
   */
  override val allowedWeaponCategories: Set[String] = Set("Sword")

  //initialize action points
  calculateMaxActionPoints()
  rebootActionBar()
}
