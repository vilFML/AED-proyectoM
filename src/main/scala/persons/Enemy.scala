package cl.uchile.dcc
package persons

import map.Panel


/**
 * ENEMIGO
 *1. Nombre
 *2. Puntos de vida
 *3. Puntos de Ataque
 *4. Puntos de Defensa
 *5. Peso
 */
class Enemy(override val name: String) extends Person{

  var healthPoints: Int = 100
  var attackPoints: Int = 10
  var defensePoints: Int = 20
  
  var weight: Int = 30
  
  var isHostile: Boolean = true

  /**
   * initializes with 100 points for actions
   */
  override val maxActionPoints: Int = 100

  /**
   * starts with full action points
   */
  override val currentActionPoints: Int = maxActionPoints

  /**
   * calculate the max action points for the PJ
   */
  override def calculateMaxActionPoints(): Int = ???
}

