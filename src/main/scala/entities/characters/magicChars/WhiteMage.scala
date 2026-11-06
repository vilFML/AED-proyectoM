package cl.uchile.dcc
package persons.characters.magicChars

import actions.ofensives.Attack
import actions.support.{Cure, Purification}
import actions.use.{ConsumePotion, EquipWeapon}
import actions.{Action, Move}

class WhiteMage(name: String = "White Mage") extends AbstractMagicCharacter(name) {

  /**
   * each stat for role
   */
  var healthPoints: Int = 75
  var attackPoints: Int = 5
  var defensePoints: Int = 30
  var weight: Int = 15

  /**
   * has mana points
   */
  override val manaPoints: Int = 100

  /**
   * attackType per role
   */
  override val attackType: String = "Magical"

  /**
   * role name
   */
  val role: String = "White Mage"

  /**
   * role magic power (only heals)
   *
   * @return
   */
  override def healPower: Double = attackPoints * 2.0 + manaPoints * 0.1

  /**
   * available actions per role
   */
  override protected val availableActions: List[Action] =
    List(new Attack, new Cure, new Purification, new Move, new EquipWeapon, new ConsumePotion)

  /**
   * can only use wands
   */
  override val allowedWeaponCategories: Set[String] = Set("Wand")

  //initialize action points
  calculateMaxActionPoints()
  rebootActionBar()












  /**
   * can only wield bows
   */
}
