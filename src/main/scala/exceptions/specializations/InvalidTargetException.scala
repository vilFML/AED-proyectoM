package cl.uchile.dcc
package exceptions.specializations

import exceptions.GameException

/**
 * purification only to enemy
 * cure only for playable character
 * @param message to display
 */
class InvalidTargetException(message: String) extends GameException(message){

}
