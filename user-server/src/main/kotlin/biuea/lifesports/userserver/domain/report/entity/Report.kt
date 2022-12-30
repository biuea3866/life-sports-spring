package biuea.lifesports.userserver.domain.report.entity

import biuea.lifesports.userserver.domain.users.entity.User
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "Reports")
class Report(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    var title: String,

    var description: String,

    @Column(name = "created_at")
    var createdAt: ZonedDateTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    var user: User
) {
}