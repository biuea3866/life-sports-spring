package biuea.lifesports.userserver.domain.reviews.entity

import biuea.lifesports.userserver.domain.reviews.constants.ReviewStatus
import biuea.lifesports.userserver.domain.reviews.constants.ReviewType
import biuea.lifesports.userserver.domain.users.entity.User
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "Reviews")
class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    var title: String,

    var description: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "review_type", nullable = false)
    var reviewType: ReviewType,

    @Enumerated(EnumType.STRING)
    @Column(name = "review_status", nullable = false)
    var reviewStatus: ReviewStatus,

    @Column(name = "created_at")
    var createdAt: ZonedDateTime,

    @Column(name = "updated_at")
    var updatedAt: ZonedDateTime? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_id")
    @JoinColumn(name = "user_id", nullable = false)
    var user: User
) {
}