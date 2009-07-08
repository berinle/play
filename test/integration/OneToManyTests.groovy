import grails.test.*

class OneToManyTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testOneToMany() {

		new Car().addToWheels(new Wheel()).save()
		assertEquals 1, Car.list().size()
		assertEquals 1, Wheel.list().size()
		
		Car.get(1).addToWheels(new Wheel())
		.addToWheels(new Wheel())
		.addToWheels(new Wheel())
		
		assertEquals 4, Wheel.list().size()
		
		Car.get(1).removeFromWheels(Wheel.get(3))
		
		//assertNull Wheel.get(3)
		assertEquals 3, Wheel.list().size()
    }
}
