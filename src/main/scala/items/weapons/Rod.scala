package cl.uchile.dcc
package items.weapons

import persons.Person

class Rod(name: String, owner: Person) extends AbstractWeapon(name, owner) {
  override val category: String = "Rod"
  override val dmgType: String = "Magical"
  var dmgPoints: Int = 30
  override val weight: Int = 10

  override def use(): Unit =
    println(s"Dealing damage with $name for $dmgPoints.")
}
