package cl.uchile.dcc
package persons.characters

import actions.{Action, Move}

import cl.uchile.dcc.actions.ofensives.Attack
import cl.uchile.dcc.actions.use.{ConsumePotion, EquipWeapon}

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
}
