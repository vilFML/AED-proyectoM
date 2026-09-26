package cl.uchile.dcc
package turns

import persons.Person

import scala.collection.mutable

class TurnScheduler extends TurnSchedulerTrait {
  /**
   * has a set of characters
   *
   * intializes empty
   */
  private val charactersInTurn: mutable.Set[Person] = mutable.Set.empty

  /**
   * to get the size of the in-turn character set
   *
   * @return
   */
  override def size: Int = {
    charactersInTurn.size
  }

  /**
   * add unit to set
   */
  override def addUnit(character: Person): Unit = {
    charactersInTurn.add(character)
  }

  /**
   * remove unit from set
   */
  override def removeUnit(character: Person): Unit = {
    charactersInTurn.remove(character)
  }


  /**
   * get if characters' turn is being managed
   * @param character
   * @return boolean
   */
  def contains(character: Person): Boolean = {
    charactersInTurn.contains(character)
  }

  /**
   * get every unit max action bar
   *
   * invokes the calculate method for every character managed
   */
  override def getMaxActionBars(): Unit = ???
    ///Idea: for every character, invoke calculate max ActionBar

  /**
   * restart units action bars
   */
  override def rebootActionBars(character: Person): Unit = ???

  /**
   * increase every action bar by a magnitude
   */
  override def increaseActionBars(amount: Int): Unit = ???

  /**
   * signal if a unit completed its action bar
   */
  override def notifyCompletedActionBar(): Unit = ???

  /**
   * output units with completed action bars
   * order: action bar surplus after completing
   */
  override def completedActionBarsUnits(): Unit = ???

  /**
   * output the unit in turn
   */
  override def outputUnitInTurn(): String = ???


}
