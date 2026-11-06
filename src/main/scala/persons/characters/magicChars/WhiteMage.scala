package cl.uchile.dcc
package persons.characters.magicChars

import actions.ofensives.Attack
import actions.support.{Cure, Purification}
import actions.use.{ConsumePotion, EquipWeapon}
import actions.{Action, Move}

class WhiteMage(name: String = "White Mage") extends AbstractMagicCharacter(name) {

  var healthPoints: Int = 75
  var attackPoints: Int = 5
  var defensePoints: Int = 30
  var weight: Int = 15

  override val manaPoints: Int = 100

  override val attackType: String = "Magical"
  val role: String = "White Mage"

  override def healPower: Double = attackPoints * 2.0 + manaPoints * 0.1

  override protected val availableActions: List[Action] =
    List(new Attack, new Cure, new Purification, new Move, new EquipWeapon, new ConsumePotion)

  override val allowedWeaponCategories: Set[String] = Set("Wand")
}
