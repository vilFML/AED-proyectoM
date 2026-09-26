package cl.uchile.dcc
package items.weapons

import persons.Person

class Wand(name: String, owner: Person) extends AbstractWeapon(name, owner) {
  override val category: String = "Wand"
  override val dmgType: String = "Magical"
  var dmgPoints: Int = 40
  override val weight: Int = 3

  override def use(): Unit =
    println(s"Dealing damage with $name for $dmgPoints.")
}
