package cl.uchile.dcc
package controller

import actions.Action

import cl.uchile.dcc.items.weapons.Weapon
import cl.uchile.dcc.map.Panel

/**
 * interface for action source
 */
trait Source {

  /**
   * delegates action's own method
   * @param action to do
   * @param target action pointed at
   */
  def doAction(action: Action, target: Target): Unit
  
  /**
   * source gives respective points by role
   * @return
   */
  def attackPower: Double

  def magicPower: Double

  def healPower: Double

  /**
   * for exception handling
   */
  def name: String
  def isAlive: Boolean
  def hasWeapon: Boolean
  def hasMagicalWeapon: Boolean
  def canSpendMana(amount: Int): Boolean
  def spendMana(amount: Int): Unit
  def canEquip(weapon: Weapon): Boolean
  def equipWeapon(weapon: Weapon): Unit
  def position: Option[Panel]
  def moveTo(panel: Panel): Unit
}
