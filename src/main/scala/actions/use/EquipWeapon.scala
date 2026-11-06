package cl.uchile.dcc
package actions.use

import controller.{Source, Target}
import exceptions.specializations.InvalidWeaponException
import items.weapons.Weapon

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

  /**
   * weapon to equip,
   * can be none
   */
  var weapon: Option[Weapon] = None

  /**
   * dispatch call for weapon equipping,
   * checks types by roles
   * @param source entity doing
   * @param target affected
   */
  override def doAction(source: Source, target: Target): Unit = {
    checkBasics(source, target)
    if (weapon.isEmpty)
      throw new IllegalStateException("EquipWeapon has no weapon")

    source.equipWeapon(weapon.get)
    target.receiveEquipWeapon(this, source)
  }
}
