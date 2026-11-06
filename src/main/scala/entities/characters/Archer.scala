package cl.uchile.dcc
package persons.characters

import actions.ofensives.Attack
import actions.use.{ConsumePotion, EquipWeapon}
import actions.{Action, Move}

class Archer(name: String = "Archer") extends AbstractCharacter(name) {

  /**
   * each stat for role
   */
  var healthPoints: Int = 50
  var attackPoints: Int = 15
  var defensePoints: Int = 5
  var weight: Int = 15

  /**
   * attackType per role
   */
  override val attackType: String = "Physical"

  /**
   * role name
   */
  val role: String = "Archer"

  /**
   * role attack power
   *
   * @return
   */
  override def attackPower: Double = attackPoints * 1.2

  /**
   * available actions per role
   */
  override protected val availableActions: List[Action] =
    List(new Attack, new Move, new EquipWeapon, new ConsumePotion)

  /**
   * can only wield bows
   */
  override val allowedWeaponCategories: Set[String] = Set("Bow")

  //initialize action points
  calculateMaxActionPoints()
  rebootActionBar()
}
