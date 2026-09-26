package cl.uchile.dcc
package items.weapons

import items.Item

import cl.uchile.dcc.persons.Person

/**
 * Abstract weapons:
 * 
 *  category: sword, bow, ...
 *  can be physical or magical
 */

abstract class AbstractWeapon(var name: String, override val owner: Person) extends Weapon {
  val category: String
  
  val dmgType: String
  var dmgPoints: Int
}
