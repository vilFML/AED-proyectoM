package cl.uchile.dcc
package controller

import actions.Move
import actions.ofensives.{Attack, Meteor, Thunder}
import actions.support.{Cure, Purification}
import actions.use.{ConsumePotion, EquipWeapon}

/**
 * interface for targeted in double dispatch
 * each method invokes the action's own method
 * and give the source
 */
trait Target {

  /**
   * target can receive attack
   * @param attack
   * @param source
   */
  def receiveAttack(attack: Attack, source: Source): Unit

  /**
   * can receive thunder cast
   * @param thunder
   * @param source
   */
  def receiveThunder(thunder: Thunder, source: Source): Unit

  /**
   * can receive meteor cast
   * @param meteor
   * @param source
   */
  def receiveMeteor(meteor: Meteor, source: Source): Unit

  /**
   * can receive cure
   * @param cure
   * @param source
   */
  def receiveCure(cure: Cure, source: Source): Unit

  /**
   * can receive purification
   * @param purification
   * @param source
   */
  def receivePurification(purification: Purification, source: Source): Unit

  /**
   * receives move action
   * @param move
   * @param source
   */
  def receiveMove(move: Move, source: Source): Unit

  /**
   * receive weapon switch
   * @param equip
   * @param source
   */
  def receiveEquipWeapon(equip: EquipWeapon, source: Source): Unit

  /**
   * receive potion consume
   * @param potion
   * @param source
   */
  def receiveConsumePotion(potion: ConsumePotion, source: Source): Unit

  /**
   * for exception handling
   */
  def name: String

  /**
   * validates alive status
   * @return
   */
  def isAlive: Boolean

  /**
   * validation enemy status
   * @return
   */
  def isEnemy: Boolean
}
