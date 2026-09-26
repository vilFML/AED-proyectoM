package cl.uchile.dcc
package items.weapons

import persons.Person

class Sword(name: String, owner: Person) extends AbstractWeapon(name, owner) {
  override val category: String = "Sword"
  override val dmgType: String = "Physical"
  var dmgPoints: Int = 30
  override val weight: Int = 20
  
  override def use(): Unit =
    println(s"Slashing with $name for $dmgPoints.")
}
