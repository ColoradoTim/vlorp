package timrapp.springbootjpah2.vlorp

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BikeRepo : JpaRepository<Bike, Int> {
    fun findByNameStartingWith(name: String): List<Bike>

    @Query("FROM Bike b WHERE b.name like %?1% ORDER BY b.id ASC")
    fun findNameContainsOrderById(substr: String): List<Bike>
}
