package timrapp.springbootjpah2.vlorp

import javax.persistence.*

@Entity
@Table(name="bikes")
class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = -1
    var name: String = ""
}
