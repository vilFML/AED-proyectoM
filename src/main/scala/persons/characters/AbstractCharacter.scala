package cl.uchile.dcc
package persons.characters

import persons.Person

import cl.uchile.dcc.items.potions.Consumable
import cl.uchile.dcc.items.weapons.Weapon
import cl.uchile.dcc.map.Panel

/**
 * Clase:
 *   - Tipo:
 *     1. Comun: no pueden usar magia
 *        i.  Caballero
 *        ii. Arquero
 *        iii.Ladrones
 *     2. Magico: tienen mana, pueden usar magia
 *        i.  Negro
 *        ii. Blanco
 * - Inventario
 */

abstract class AbstractCharacter(override val name: String) extends Person {
  var healthPoints: Int
  var attackPoints: Int
  var defensePoints: Int
  var weight: Int
  var isHostile: Boolean = false
  
  val attackType: String
  val role: String

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
   * can switch equipped weapon,
   * starts with none
   */
  protected val equippedWeapon: Option[Weapon] = None


  /**
   * every PJ starts with 100 action points
   */
  override val maxActionPoints: Int = 100

  /**
   * starts with full action points
   */
  override val currentActionPoints: Int = maxActionPoints

  /**
   * every unit has to calculate its max action points,
   * based in its own weight and its weapon's weight
   */
  override def calculateMaxActionPoints(): Int = ???
    //TODO
}
