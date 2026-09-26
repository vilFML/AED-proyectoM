package cl.uchile.dcc
package items.weapons

import persons.Person

class Dagger(name: String, owner: Person) extends AbstractWeapon(name, owner) {
  override val category: String = "Dagger"
  override val dmgType: String = "Physical"
  var dmgPoints: Int = 40
  override val weight: Int = 10
  

  override def use(): Unit =
    println(s"Stabbing with $name for $dmgPoints.")
}
