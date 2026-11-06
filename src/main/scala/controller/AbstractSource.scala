package cl.uchile.dcc
package controller

import actions.Action

/**
 * for double dispatch:
 * encapsulates logic for action sources, invoking action call
 */
abstract class AbstractSource extends Source {
  override def doAction(action: Action, target: Target): Unit =
    action.doAction(this, target)
}