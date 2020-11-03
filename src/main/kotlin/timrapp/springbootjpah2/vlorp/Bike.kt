package timrapp.springbootjpah2.vlorp

import javax.persistence.*
import java.io.Serializable

@Entity
@Table(name="bikes")
//@Serializable
data class Bike(val name: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = -1
//    var name: String = ""
}
