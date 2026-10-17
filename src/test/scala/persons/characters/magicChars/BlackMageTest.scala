package cl.uchile.dcc
package persons.characters.magicChars

import munit.FunSuite

import scala.compiletime.uninitialized

class BlackMageTest extends FunSuite {
  var blackMage: BlackMage = uninitialized

  override def beforeEach(context: BeforeEach): Unit = {
    blackMage = new BlackMage("Moon")
  }
  
  test("Can initialize with a different name"):
    assertEquals(blackMage.name, "Moon")

  test("Outputs Black Mage(Moon) when asked to identify"):
    assertEquals(blackMage.toString, "Black Mage(Moon)")
  
  test("Black Mage starts with 100 Mana points"):
    assertEquals(100, blackMage.manaPoints)

  test("Black Mage is not hostile."):
    assertEquals(blackMage.getHostility, false)

  test("Black mage can get its own max action points"):
    assertEquals(blackMage.getMaxActionPoints, 100f)

  test("Black mage can modify its action points"){
    blackMage.setCurrentActionPoints(0f)

    assertEquals(blackMage.getCurrentActionPoints,0f)
  }

  test("Black Mage can refill its action bar"):
    blackMage.setCurrentActionPoints(0f)

    assertEquals(blackMage.getCurrentActionPoints, 0f)

    blackMage.rebootActionBar()

    assertEquals(blackMage.getCurrentActionPoints, blackMage.getMaxActionPoints )

    test("Black mage can increase its action points by 20"):
      assertEquals(blackMage.getCurrentActionPoints, blackMage.getMaxActionPoints)

      blackMage.increaseActionPoints(20f)

      assertEquals(blackMage.getCurrentActionPoints, 120f)

    test("BlackMage starts with false completed action bar"):
      assertEquals(blackMage.isActionBarCompleted, false)

    test("Black mage can change its completed action bar status."){
      blackMage.updateActionBarCompletedStatus(true)
      assertEquals(blackMage.isActionBarCompleted, true)

    }
}
