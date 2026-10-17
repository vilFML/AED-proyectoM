package cl.uchile.dcc
package persons.characters.magicChars

import actions.use.ConsumePotion

import cl.uchile.dcc.actions.{Action, Move}
import cl.uchile.dcc.actions.ofensives.{Attack, Meteor, Thunder}
import cl.uchile.dcc.actions.support.{Cure, Purification}

class BlackMage(name: String = "Black Mage") extends AbstractMagicCharacter(name) {
  var healthPoints: Int = 75
  var attackPoints: Int = 20
  var defensePoints: Int = 15
  var weight: Int = 20

  override val manaPoints: Int = 100

  override val attackType: String = "Magical"
  val role: String = "Black Mage"

  override def magicPower: Double = attackPoints * 2.0 + manaPoints * 0.1

  override protected val availableActions: List[Action] =
    List(new Attack, new Thunder, new Meteor, new Move, new ConsumePotion)
}
