package cl.uchile.dcc
package persons.characters.magicChars

import actions.ofensives.{Attack, Meteor, Thunder}
import actions.use.{ConsumePotion, EquipWeapon}
import actions.{Action, Move}

class BlackMage(name: String = "Black Mage") extends AbstractMagicCharacter(name) {

  /**
   * each stat for role
   */
  var healthPoints: Int = 75
  var attackPoints: Int = 20
  var defensePoints: Int = 15
  var weight: Int = 20

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
  val role: String = "Black Mage"

  /**
   * role magic attack power
   *
   * @return
   */
  override def magicPower: Double = attackPoints * 2.0 + manaPoints * 0.1

  /**
   * available actions per role
   */
  override protected val availableActions: List[Action] =
    List(new Attack, new Thunder, new Meteor, new Move, new EquipWeapon, new ConsumePotion)

  /**
   * can only wield rods
   */
  override val allowedWeaponCategories: Set[String] = Set("Rod")

  //initialize action points
  calculateMaxActionPoints()
  rebootActionBar()
}
