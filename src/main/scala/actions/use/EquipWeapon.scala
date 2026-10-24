package cl.uchile.dcc
package actions.use

import actions.use.AbstractUse

import cl.uchile.dcc.controller.{Source, Target}
import cl.uchile.dcc.exceptions.specializations.InvalidWeaponException
import cl.uchile.dcc.items.weapons.Weapon
import scala.collection.mutable.ArrayBuffer

class EquipWeapon extends AbstractUse {

  /**
   * has a name
   */
  override val name: String = "EquipWeapon"
  /**
   * action to use items requires a list of items
   * starts empty
   */
  var usables: ArrayBuffer[String] = ArrayBuffer.empty[String]
  
  var weapon: Option[Weapon] = None
  
  override def doAction(source: Source, target: Target): Unit = {
    checkBasics(source, target)
    if (weapon.isEmpty)
      throw new IllegalStateException("EquipWeapon has no weapon")
    if (!source.canEquip(weapon.get))
      throw new InvalidWeaponException(
        s"${source.name} cannot equip ${weapon.get.name} (${weapon.get.category})")

    source.equipWeapon(weapon.get)
    target.receiveEquipWeapon(this, source)
  }
}
