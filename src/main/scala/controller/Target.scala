package cl.uchile.dcc
package controller

import actions.ofensives.AbstractOffensiveAction

import cl.uchile.dcc.actions.Action

/**
 * interface for targeted in double dispatch
 */
trait Target {
  def receiveAttack(power: Int): Unit
}
