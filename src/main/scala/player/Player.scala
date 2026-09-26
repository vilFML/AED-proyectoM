package cl.uchile.dcc
package player

import persons.Person



/* PLAYER
1. Lista de unidades
2. Mostrar derrota o no
 */

trait Player {
  var units: Set[Person]
  
  def getDefeated(): Unit
}
