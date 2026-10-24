package cl.uchile.dcc
package controller

import actions.ofensives.{AbstractOffensiveAction, Attack}

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
  def receiveAttack(attack: Attack, source: Source): Unit

  def receiveThunder(thunder: Thunder, source: Source): Unit

  def receiveMeteor(meteor: Meteor, source: Source): Unit

  def receiveCure(cure: Cure, source: Source): Unit

  def receivePurification(purification: Purification, source: Source): Unit

  def receiveMove(move: Move, source: Source): Unit

  def receiveEquipWeapon(equip: EquipWeapon, source: Source): Unit

  def receiveConsumePotion(potion: ConsumePotion, source: Source): Unit

  /**
   * for exception handling
   */
  def name: String
  def isAlive: Boolean
  def isEnemy: Boolean
}
