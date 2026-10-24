package cl.uchile.dcc
package exceptions.specializations

import exceptions.GameException

/**
 * defeated unit cant receive action
 * @param message to display
 */
class DefeatedUnitException(message: String) extends GameException(message){

}
