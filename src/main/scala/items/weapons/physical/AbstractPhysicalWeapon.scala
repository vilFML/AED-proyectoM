package cl.uchile.dcc
package items.weapons.physical

import items.weapons.AbstractWeapon

/**
 * Specialization of physical damage weapons
 */
abstract class AbstractPhysicalWeapon extends AbstractWeapon {
  /**
   *
   */
  val dmgType: String = "Physical"
}
