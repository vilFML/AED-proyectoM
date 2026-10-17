package cl.uchile.dcc
package persons.characters

import items.potions.Consumable
import items.weapons.Weapon
import persons.Entity

import cl.uchile.dcc.actions.{Action, Move}
import cl.uchile.dcc.actions.ofensives.{Attack, Meteor, Thunder}
import cl.uchile.dcc.actions.support.{Cure, Purification}
import cl.uchile.dcc.actions.use.{ConsumePotion, EquipWeapon}
import cl.uchile.dcc.controller.{AbstractSource, Source}

/**
 * specializes a playable character
 */
abstract class AbstractCharacter(val name: String) extends AbstractSource with Entity {

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

  override def rebootActionBar(): Unit = {
    currentActionPoints = maxActionPoints                                  //replaces the current action point with the max
    actionBarCompleted = false
  }

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

  /**
   * base getters, role overrides
   *  @return respective point
   */
  override def attackPower: Double = attackPoints.toDouble
  override def magicPower: Double = attackPoints.toDouble
  override def healPower: Double = 0.0

  /**
   * store role's actions
   */
  protected val availableActions: List[Action]
  override def getAvailableActions: List[Action] = availableActions

  /**
   * character receives damage
   * @param raw dmg to process
   */
  protected def applyDamage(raw: Double): Unit = {
    val dmg = math.max(0.0, raw - defensePoints).toInt
    healthPoints = math.max(0, healthPoints - dmg)
  }

  /**
   * receive dispatches
   * @param 
   * @param source
   */
  override def receiveAttack(attack: Attack, source: Source): Unit =
    applyDamage(attack.basePower + source.attackPower)
  override def receiveThunder(thunder: Thunder, source: Source): Unit =
    applyDamage(thunder.basePower + source.magicPower)
  override def receiveMeteor(metheor: Meteor, source: Source): Unit =
    applyDamage(metheor.basePower + source.magicPower)
  override def receiveCure(cure: Cure, source: Source): Unit =
    healthPoints += (cure.baseHeal + source.healPower).toInt

  override def receivePurification(p: Purification, source: Source): Unit = ()
  override def receiveMove(move: Move, source: Source): Unit = ()
  override def receiveEquipWeapon(e: EquipWeapon, source: Source): Unit = ()
  override def receiveConsumePotion(c: ConsumePotion, source: Source): Unit = ()
}
