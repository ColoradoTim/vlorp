package timrapp.springbootjpah2.vlorp

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "bikes")
// @Serializable
data class Bike(val name: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = -1
//    var name: String = ""
}
