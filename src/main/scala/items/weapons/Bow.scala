package cl.uchile.dcc
package items.weapons

import persons.Person

class Bow(name: String, owner: Person) extends AbstractWeapon(name, owner) {
  override val category: String = "Bow"
  override val dmgType: String = "Physical"
  var dmgPoints = 20
  override val weight: Int = 5

  override def use(): Unit =
    println(s"Attacking with $name for $dmgPoints")

}
