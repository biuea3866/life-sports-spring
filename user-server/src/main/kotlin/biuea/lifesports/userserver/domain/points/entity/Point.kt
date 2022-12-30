package biuea.lifesports.userserver.domain.points.entity

import biuea.lifesports.userserver.domain.users.entity.User
import javax.persistence.*

@Entity
@Table(name = "Points")
class Point(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    var point: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_id")
    @JoinColumn(name = "user_id", nullable = false)
    var user: User
) {
}