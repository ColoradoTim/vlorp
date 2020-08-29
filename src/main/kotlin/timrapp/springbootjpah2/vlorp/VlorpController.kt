package timrapp.springbootjpah2.vlorp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/bikes")
class VlorpController {
    @Autowired
    lateinit var bikeService: BikeService

    @GetMapping("/")
    fun index(): List<Bike>? {
        return bikeService.findAll()
    }

    @GetMapping("/nameStartsWith")
    fun findByNameStartsWith(@RequestParam start: String): List<Bike> {
        return bikeService.findByNameStartingWith(start)
    }

    @GetMapping("/nameContains")
    fun findNameContains(@RequestParam start: String): List<Bike> {
        return bikeService.findNameContainsOrderById(start)
    }

    @PostMapping("/")
    @ResponseBody
    fun addBike(@RequestBody bike: Bike): List<Bike> {
        println("adding bike")
        return bikeService.create(bike)
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    fun deleteBike(@PathVariable("id") id: Int): List<Bike> {
        println("Start deleteBike.")
        return bikeService.delete(id)
    }
}
