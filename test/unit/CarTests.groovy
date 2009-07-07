import grails.test.*

class CarTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

	void testSomething() {
		mockDomain(Wheel)
		def w = new Wheel()
		assertTrue w.validate()
		assertFalse w.hasErrors()
	}
	
    void testRelationship() {
		mockDomain(Car)
		mockDomain(Wheel)
		//new Car().addToWheels(new Wheel()).save()
		def car = new Car().save()
		def wheel = new Wheel()
		wheel.save()
		car.addToWheels(wheel).save()
		
		assertEquals 1, Car.list().size()
		assertEquals 1, Wheel.list().size()

		Car.list(fetch:[wheels:'join']) //prove you can eagerly fetch collection

		def w2 = new Wheel().save()
		def w3 = new Wheel().save()
		def w4 = new Wheel().save()
		
		Car.get(1).addToWheels(w2)
		.addToWheels(w3)
		.addToWheels(w4)
		.save()
		
		/*Car.get(1).addToWheels(new Wheel())
		.addToWheels(new Wheel())
		.addToWheels(new Wheel())
		.save()*/

		assertEquals 4, Wheel.list().size()

		Car.get(1).removeFromWheels(Wheel.get(3)).save()

		assertEquals 3, Wheel.list().size()
    }
}
