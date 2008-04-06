package groovy.demo.dsl

class TestJourneyDsl extends GroovyTestCase {
	Journey journey

	void setUp() {
		journey = new Journey()

		assert journey.destination.x == 0
		assert journey.destination.y == 0
	}

	void testShouldGoAroundInACircle() {

		journey.forwards(5)
			   .turnEast()
			   .forwards(5)
			   .turnSouth()
			   .forwards(5)
			   .turnWest()
			   .forwards(5)

		assert journey.destination.x == 0
		assert journey.destination.y == 0
	}

	void testShouldWalkDiagonallyinAUniverseWherePythagorasWasWrong() {

		journey.turnNorthEast().forwards(5)

		assert journey.destination.x == 5
		assert journey.destination.y == 5
	}
}