package cl.uchile.dcc
package turns

import cl.uchile.dcc.persons.Person
import munit.FunSuite

class TurnSchedulerTest extends FunSuite {
  //structure for testing
  private var scheduler: TurnScheduler = _
  
  private val protagonist: Person = new Person {
    override val name: String = "Moon"
    var healthPoints: Int = 100
    var attackPoints: Int = 20
    var defensePoints: Int = 20
    var weight: Int = 25
    var isHostile: Boolean = false
  }

  override def beforeEach(context: BeforeEach): Unit = {
    scheduler = new TurnScheduler
  }
  
  //Tests
  test("new turnScheduler has no units."){
    assertEquals(scheduler.size, 0)
  }
  
  test("unit can get added to turnScheduler."){
    scheduler.addUnit(protagonist)
    
    assertEquals(scheduler.size, 1)
  }
  
  test("unit can get removed from turnScheduler."){
    scheduler.addUnit(protagonist)
    scheduler.removeUnit((protagonist))
    
    assertEquals(scheduler.size, 0)
  }
  
  

}
