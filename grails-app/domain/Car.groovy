class Car {

	static hasMany =  [wheels:Wheel]
    static constraints = {
    }

	static mapping = {
		wheels cascade:'save-update,delete-orphan'
	}
}
