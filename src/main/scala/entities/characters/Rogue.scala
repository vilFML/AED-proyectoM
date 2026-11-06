package cl.uchile.dcc
package persons.characters

import actions.ofensives.Attack
import actions.use.{ConsumePotion, EquipWeapon}
import actions.{Action, Move}

class Rogue(name: String = "Rogue") extends AbstractCharacter(name) {

  /**
   * each stat for role
   */
  var healthPoints: Int = 50
  var attackPoints: Int = 35
  var defensePoints: Int = 5
  var weight: Int = 10

  /**
   * attackType per role
   */
  override val attackType: String = "Physical"

  /**
   * role name
   */
  val role: String = "Rogue"

  /**
   * role attack power
   *
   * @return
   */
  override def attackPower: Double = attackPoints * 1.3

  /**
   * available actions per role
   */
  override protected val availableActions: List[Action] =
    List(new Attack, new Move, new EquipWeapon, new ConsumePotion)

  /**
   * can only wield daggers
   */
  override val allowedWeaponCategories: Set[String] = Set("Dagger")

  //initialize action points
  calculateMaxActionPoints()
  rebootActionBar()
}
