package cl.uchile.dcc
package exceptions.specializations

import exceptions.GameException

/**
 * character cant equip if no weapon
 * @param message to display
 */
class MissingWeaponException(message: String) extends GameException(message){

}
