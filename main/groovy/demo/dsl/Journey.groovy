package groovy.demo.dsl

class Journey {
	def destination = [
		x: 0,
		y: 0
	]

	private direction = 'North'

	def methodMissing(String name, args) {
        if (name.startsWith('turn') ) {
            direction = name.substring(4)
            println "Direction now ${direction}"
        }
        this
    }

	def forwards(distance) {

		if (direction.contains('North')) {
			destination.y += distance
		}
		if (direction.contains('East')) {
			destination.x += distance
		}
		if (direction.contains('South')) {
			destination.y -= distance
		}
		if (direction.contains('West')) {
			destination.x -= distance
		}

		println destination
		this
	}
}