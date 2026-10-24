package cl.uchile.dcc
package actions

import controller.{Source, Target}
import exceptions.specializations.InvalidMoveException
import map.Panel

/**
 * movement concrete class
 * @param destination panel, defaults to none
 */
class Move(var destination: Option[Panel] = None) extends AbstractAction {

  /**
   * has a name
   */
  override protected val name: String = "Move"

  override def doAction(source: Source, target: Target): Unit = {
    checkBasics(source, target)
    if (source.position.isEmpty)
      throw new IllegalStateException(s"${source.name} is not in the map")
    if (destination.isEmpty)
      throw new IllegalStateException("Move has no destination")

    val from: Panel = source.position.get
    val to: Panel = destination.get
    if (!from.isAdjacent(to))
      throw new InvalidMoveException(
        s"${source.name} cannot move from (${from.x}, ${from.y}) to (${to.x}, ${to.y}): panels are not adjacent")

    source.moveTo(to)
    target.receiveMove(this, source)
  }
}
