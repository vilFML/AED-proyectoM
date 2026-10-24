package cl.uchile.dcc
package exceptions.specializations

import exceptions.GameException

/**
 * magic char has to have enough mana
 * @param message to display
 */
class InsufficientManaException(message: String) extends GameException(message){

}
