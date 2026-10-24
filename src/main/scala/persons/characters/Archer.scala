package cl.uchile.dcc
package persons.characters

import actions.{Action, Move}

import cl.uchile.dcc.actions.ofensives.Attack
import cl.uchile.dcc.actions.use.{ConsumePotion, EquipWeapon}

class Archer(name: String = "Archer") extends AbstractCharacter(name) {
  
  var healthPoints: Int = 50
  var attackPoints: Int = 15
  var defensePoints: Int = 5
  var weight: Int = 15

  override val attackType: String = "Physical"
  val role: String = "Archer"

  override def attackPower: Double = attackPoints * 1.2

  override protected val availableActions: List[Action] =
    List(new Attack, new Move, new EquipWeapon, new ConsumePotion)

  override val allowedWeaponCategories: Set[String] = Set("Bow")
}
