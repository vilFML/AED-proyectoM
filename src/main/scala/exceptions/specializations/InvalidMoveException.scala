package cl.uchile.dcc
package exceptions.specializations

import exceptions.GameException

/**
 * entity can move only to an adjacent panel
 * @param message to display
 */
class InvalidMoveException(message: String) extends GameException(message){

}
