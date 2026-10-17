package cl.uchile.dcc
package controller

import actions.Action

abstract class AbstractSource extends Source {
  override def doAction(action: Action, target: Target): Unit =
    action.doAction(this, target)
}