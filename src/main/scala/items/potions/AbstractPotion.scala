package cl.uchile.dcc
package items.potions

/*
Pociones:
  - Nombre
  - tipo:
    - Cura
    - Fortaleza
    - Mana
    - Fza magica
 */

abstract class AbstractPotion extends Consumable {
  var name: String
  
  val points: Int
  
  def use(): Unit =
    println(s"$name potion consumed.")
}
