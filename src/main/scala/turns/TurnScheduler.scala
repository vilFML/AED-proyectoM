package cl.uchile.dcc
package turns

import persons.Person

import scala.collection.mutable

/**
 * keeps track of currently in-turn pjs
 */
class TurnScheduler extends TurnSchedulerTrait {

  /**
   * Stores pjs names with its reference, starts empty
   */
  private val managedCharacters: mutable.Map[String, Person] = mutable.Map[String, Person]()

  /**
   * stores pjs max action points,
   * access by pj name
   */
  private val allCurrentActionPoints: mutable.Map[String, Float] = mutable.Map[String, Float]()

  /**
   * stores the unique character in turn
   * starts with no character
   */
  private var currentlyInTurnCharacter: Option[Person] = None
  
  /**
   * add unit to set
   */
  override def addUnit(character: Person): Unit = {
    val nameToAdd: String = character.name

    managedCharacters(nameToAdd) = character                                     //stores reference to pj
    allCurrentActionPoints(nameToAdd) = character.getMaxActionPoints            //stores pj max action points
  }

  /**
   * remove unit from set
   */
  override def removeUnit(character: Person): Unit = {
    val nameToRemove: String = character.name
    
    managedCharacters -= nameToRemove
  }

  /**
   * get if pj is currently in its turn
   * @param character the pj to check
   * @return true if it is in turn
   */
  def isInTurn(character: Person): Boolean = {
    var res: Boolean = false

    if currentlyInTurnCharacter.isEmpty then                                    //no char in-turn
      res = false

    else
      if currentlyInTurnCharacter.get.name == character.name then               //in turn char's name is the same
        res = true
      else                                                                      //not same name
        res = false

    res
  }

  /**
   * to get the size of the in-turn character set
   *
   * @return an int representing the number of in-turn pjs
   */
  override def getTotalManagedCharacters: Int = {
    managedCharacters.size
  }

  /**
   * asks to every pj to output its max action bars
   */
  override def calculateAllMaxActionBars(): Unit = {
    for pj <- managedCharacters.values do pj.calculateMaxActionPoints()
  }

  /**
   * restart units action bars
   */
  override def rebootActionBars(character: Person): Unit =
    for pj <- managedCharacters.values do pj.rebootActionBar()

  override def increaseActionBars(amount: Float): Unit =
    for pj <- managedCharacters.values do pj.increaseActionPoints(amount)

  override def notifyCompletedActionBar(character: Person): Unit = {
    if (character.isActionBarCompleted){
      println(s"${character.toString} completed its action bar.")
    }

    }

  /**
   * output the unit in turn
   */
  override def getInTurnUnit: Option[Person] = {
    var returnChar: Option[Person] = None                                       //asumes no char is in turn
    if (currentlyInTurnCharacter.isEmpty) {
      println("There is no character currently in turn.")
    }
    else{                                                                       //if there is a in-turn pj
      returnChar = currentlyInTurnCharacter                                     //return the object
      println(s"Currenyly in-turn character: ${returnChar.toString}")           //print the character in turn
    }

    returnChar
  }

  override def setInTurnUnit(character: Person): Boolean = {
    var res: Boolean = false

    if (isInTurn(character)){                                                   //if pj is already in turn, do nothing
      println(s"Character ${character.toString} is already in turn.")
    }
    else{                                                                       //else: change in-turn pj
      println(s"Character ${character.toString} is now in turn.")
      currentlyInTurnCharacter = Some(character)
      res = true
    }

    res
  }


  override def getCompletedActionBarsUnits: List[(String, Float)] =
    // 1. get (name, surplus) of completed action charcts
    val completedSurplus: mutable.ListBuffer[(String, Float)] =
      mutable.ListBuffer.empty[(String, Float)]

    for pj <- managedCharacters.values do
      if pj.isActionBarCompleted then                                           //check completed action bar per charact
        completedSurplus += ((pj.name, pj.getCurrentActionPoints))              //add to list

    // 2. Order by AP surplus
    val ordered: List[(String, Float)] =
      completedSurplus.toList.sortBy(_._2).reverse

    // 3. Print the result
    if ordered.isEmpty then
      println("No character has completed its action bar.")                     //print if theres no completed action bar
    else
      println("Characters with completed action bar (by remaining AP):")
      for (name, ap) <- ordered do
        println(s"  $name — $ap AP")                                            //print pj with AP, 1 per line

    ordered
}
