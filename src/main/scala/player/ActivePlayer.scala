package cl.uchile.dcc
package player

import persons.Person

class ActivePlayer extends Player {
  var units: Set[Person] = Set[Person]()

  override def getDefeated(): Unit = 
    println("Not yet.")
}
