package cl.uchile.dcc
package items.weapons

import items.Item

trait Weapon extends Item{
  val category: String

  val dmgType: String
  var dmgPoints: Int
}
