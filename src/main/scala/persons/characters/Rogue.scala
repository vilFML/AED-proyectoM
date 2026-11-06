package cl.uchile.dcc
package persons.characters

import actions.ofensives.Attack
import actions.use.{ConsumePotion, EquipWeapon}
import actions.{Action, Move}

class Rogue(name: String = "Rogue") extends AbstractCharacter(name) {
  var healthPoints: Int = 50
  var attackPoints: Int = 35
  var defensePoints: Int = 5
  var weight: Int = 10

  override val attackType: String = "Physical"
  val role: String = "Rogue"

  override def attackPower: Double = attackPoints * 1.3

  override protected val availableActions: List[Action] =
    List(new Attack, new Move, new EquipWeapon, new ConsumePotion)

  override val allowedWeaponCategories: Set[String] = Set("Dagger")
}
