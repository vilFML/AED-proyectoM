package cl.uchile.dcc
package persons.characters

import items.potions.Consumable
import items.weapons.Weapon
import persons.Person

/**
 * specializes a playable character
 */
abstract class AbstractCharacter(val name: String) extends Person {

  /**
   * text representation of pj
   * @return string of Class
   */
  override def toString: String = s"$role($name)"

  /**
   * playable chars have weight
   */
  protected var weight: Int

  /**
   * playable char is not hostile
   */
  private var isHostile: Boolean = false

  /**
   * can be knight, rogue, ...
   */
  val role: String

  /**
   * attack type given by role
   */
  val attackType: String

  /**
   * Has a set of consumables,
   * starts empty
   */
  protected var consumablesInventory: Set[Consumable] = Set[Consumable]()

  /**
   * Has weapons,
   * starts with no weapons
   */
  protected val weaponInventory: Set[Weapon] = Set[Weapon]()

  /**
   * weapons can be switched,
   * starts with none
   */
  private var equippedWeapon: Option[Weapon] = None

  /**
   * every PJ starts with 100 action points
   */
  private var maxActionPoints: Float = 100

  /**
   * starts with full action points
   */
  private var currentActionPoints: Float = maxActionPoints

  /**
   * pj keeps track if its action bar is completed
   * starts false
   */
  private var actionBarCompleted: Boolean = false

  /**
   * Unit calculates and updates its max action points,
   * based in weight and weapon's weight
   */
  override def calculateMaxActionPoints(): Unit = {
    //initialize action points parameters
    val baseMax: Float = 1000f
    var maxPoints: Float = 0                                                    //for return
    
    //store weights
    val weaponWeight: Float = equippedWeapon.map(_.getWeight).getOrElse(0f)
    val pjWeight: Float = this.getWeight

    maxPoints = baseMax - weaponWeight - pjWeight
    maxActionPoints = maxPoints
  }

  /**
   * getter for the stored max action points
   *  @return a float with the pj's max action points
   */
  override def getMaxActionPoints: Float = maxActionPoints

  override def setCurrentActionPoints(amount: Float): Unit = {
    currentActionPoints = amount                                                //replaces the variable
  }

  override def getCurrentActionPoints: Float =
    currentActionPoints

  /**
   * every character outputs its hostility
   * @return false
   */
  override def getHostility: Boolean =
    this.isHostile

  override def getWeight: Float =
    this.weight

  override def rebootActionBar(): Unit =
    currentActionPoints = maxActionPoints                                      //replaces the current action point with the max

  override def increaseActionPoints(amount: Float): Unit =
    currentActionPoints += amount                                               //sums the amount to increase

  override def isActionBarCompleted: Boolean = {
    var res: Boolean = false

    if (actionBarCompleted)                                                     //checks for completedActionBar state
      res = true

    res
  }

  override def updateActionBarCompletedStatus(newStatus: Boolean): Boolean = {

    if actionBarCompleted == newStatus then
      println(s"Completed action bar status already $newStatus")
      false

    else
      actionBarCompleted = newStatus
      println(s"Completed ActionBar status updated to $newStatus")
      true

  }

}
