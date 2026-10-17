package cl.uchile.dcc
package items.weapons.magical

import items.weapons.AbstractWeapon

/**
 * abstract class for magical weapons
 */
abstract class AbstractMagicalWeapon extends AbstractWeapon {
  /**
   * magical damage type
   */
  val dmgType: String = "Magical"
}
