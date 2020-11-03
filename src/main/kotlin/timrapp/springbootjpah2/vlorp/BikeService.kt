package timrapp.springbootjpah2.vlorp

import org.springframework.stereotype.Service

@Service
class BikeService(val bikeRepo: BikeRepo) {
    val unacceptableBrands = setOf("Magna", "Huffy", "Schwinn")

    fun findAll(): List<Bike> {
        return bikeRepo.findAll()
    }

    fun findByNameStartingWith(name: String): List<Bike> {
        return bikeRepo.findByNameStartingWith(name)
    }

    fun findNameContainsOrderById(substr: String): List<Bike> {
        return bikeRepo.findNameContainsOrderById(substr)
    }

    fun create(bike: Bike): List<Bike> {
        if (unacceptableBrands.contains(bike.name)) {
            throw IllegalArgumentException("Please only add good bikes.")
        }

        bikeRepo.save(bike)
        return bikeRepo.findAll()
    }

    fun delete(id: Int): List<Bike> {
        bikeRepo.deleteById(id)
        return bikeRepo.findAll()
    }
}
