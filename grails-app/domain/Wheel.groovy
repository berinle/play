class Wheel {

	static belongsTo = [car:Car]
    static constraints = {
		car nullable:true
    }
	
}
