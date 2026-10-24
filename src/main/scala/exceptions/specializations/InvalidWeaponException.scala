package cl.uchile.dcc
package exceptions.specializations

import exceptions.GameException

/**
 * violation of weapon type restriction
 * @param message to display
 */
class InvalidWeaponException(message: String) extends GameException(message){

}
