package cl.uchile.dcc
package persons

import actions.ofensives.Attack
import actions.{Action, Move}
import persons.characters.AbstractCharacter


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

  /**
   * enemies fixed weight
   */
  var weight: Int = 30

  /**
   * custom role for enemies
   */
  val role: String = "Enemy"

  /**
   *
   */
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
   * enemies actions:
   * only attack and move
   */
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

  /**
   * initialize action points
   */
  calculateMaxActionPoints()
  rebootActionBar()

}

