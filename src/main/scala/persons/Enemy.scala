package cl.uchile.dcc
package persons


/**
 * class for enemy units
 */
class Enemy{

  /**
   *  name defaults to "Enemy"
   */
  var name: String = "Enemy"

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
   * weight defaults to 30
   */
  private var weight: Float = 30.0

  /**
   * is always hostile
   */
  private val isHostile: Boolean = true
  
  /**
   * every enemy is hostile
   */
  def getHostility: Boolean =
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

  def getWeight: Float =
    this.weight

  /**
   * calculate the max action points for the PJ
   */
  def getMaxActionPoints: Float =
    100 - this.weight
}

