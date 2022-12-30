package biuea.lifesports.userserver.domain.histories.entity

import biuea.lifesports.userserver.domain.histories.constants.HistoryType
import biuea.lifesports.userserver.domain.users.entity.User
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "Histories")
class History(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Enumerated(EnumType.STRING)
    val historyType: HistoryType,

    val description: String,

    @Column(name = "created_at", nullable = false)
    val createdAt: ZonedDateTime = ZonedDateTime.now(),

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_id")
    @JoinColumn(name = "user_id", nullable = false)
    var user: User
) {
}