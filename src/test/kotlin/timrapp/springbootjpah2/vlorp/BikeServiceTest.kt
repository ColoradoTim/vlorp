package timrapp.springbootjpah2.vlorp

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class BikeServiceTest {
    @Test
    fun findAll() {
        val mockBikeRepo = mock(BikeRepo::class.java)
        val bikes = listOf(Bike("tricross"))
        Mockito.`when`(mockBikeRepo.findAll()).thenReturn(bikes)
        val service = BikeService(mockBikeRepo)

        assert(service.findAll() == bikes)
    }

    @Test
    fun findByNameStartingWith() {
        val mockBikeRepo = mock(BikeRepo::class.java)
        val tricross = Bike("tricross")
        val bikes = listOf(tricross)
        Mockito.`when`(mockBikeRepo.findByNameStartingWith("T")).thenReturn(bikes)
        val service = BikeService(mockBikeRepo)

        val foundBikes = service.findByNameStartingWith("T")
        assert(foundBikes.size == 1)
        assert(foundBikes[0] == tricross)
    }

    @Test
    fun create() {
        val mockBikeRepo = mock(BikeRepo::class.java)
        val bikes = listOf(Bike("Pivot"))
        Mockito.`when`(mockBikeRepo.findAll()).thenReturn(bikes)
        val service = BikeService(mockBikeRepo)

        val yeti = Bike("Yeti")
        val createdBikes = service.create(yeti)
        assert(createdBikes.size == 1)
    }

    @Test
    fun create_invalid() {
        val mockBikeRepo = mock(BikeRepo::class.java)
        val service = BikeService(mockBikeRepo)

        val magna = Bike("Magna")
        assertThrows(IllegalArgumentException::class.java) { service.create(magna) }
    }
}
