package cl.uchile.dcc
package persons

import persons.characters.AbstractCharacter

import cl.uchile.dcc.actions.ofensives.Attack
import cl.uchile.dcc.actions.{Action, Move}


/**
 * class for enemy units
 */
class Enemy(name: String = "Enemy") extends AbstractCharacter(name) {

  /**
   *  starts with 100 health points
   */
  var healthPoints: Int = 100

  /**
   *  attack points default to 100
   */
  var attackPoints: Int = 1

  /**
   *  defense points default to 20
   */
  var defensePoints: Int = 20

  var weight: Int = 30
  val role: String = "Enemy"
  override val attackType: String = "Physical"
  
  /**
   * is always hostile
   */
  private val isHostile: Boolean = true
  
  /**
   * every enemy is hostile
   */
  override def getHostility: Boolean =
    isHostile

  /**
   * 100 action points base,
   * weight decreases action points available
   */
  protected val maxActionPoints: Float = 100 - this.weight

  /**
   * starts with full action points
   */
  val currentActionPoints: Float = maxActionPoints

  override def getWeight: Float =
    this.weight

  /**
   * calculate the max action points for the PJ
   */
  override def getMaxActionPoints: Float =
    100f - weight

  override protected val availableActions: List[Action] =
    List(new Attack, new Move)

  /**
   * is always hostile
   *  @return true
   */
  override def isEnemy: Boolean = true

  /**
   * enemy doesnt need weapon to attack
   * @return true
   */
  override def hasWeapon: Boolean = true

}

