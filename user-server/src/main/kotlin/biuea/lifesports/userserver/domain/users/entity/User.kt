package biuea.lifesports.userserver.domain.users.entity

import biuea.lifesports.userserver.domain.alerts.entity.Alert
import biuea.lifesports.userserver.domain.histories.entity.History
import biuea.lifesports.userserver.domain.points.entity.Point
import biuea.lifesports.userserver.domain.report.entity.Report
import biuea.lifesports.userserver.domain.reviews.entity.Review
import biuea.lifesports.userserver.domain.users.constants.UserGrade
import biuea.lifesports.userserver.domain.users.constants.UserStatus
import org.springframework.security.crypto.bcrypt.BCrypt
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "Users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    var email: String,

    var password: String,

    var nickname: String,

    var name: String? = null,

    var phone: String? = null,

    @Enumerated(EnumType.STRING)
    var status: UserStatus = UserStatus.ACTIVE,

    @Enumerated(EnumType.STRING)
    var grade: UserGrade,

    @Column(name = "created_date", nullable = false)
    var createdDate: ZonedDateTime,

    @Column(name = "updated_date")
    var updatedDate: ZonedDateTime? = null,

    @Column(name = "last_login_at")
    var lastLoginAt: ZonedDateTime? = null,
//    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
//    var reviews: MutableList<Review> = mutableListOf(),

//    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
//    var points: MutableList<Point> = mutableListOf(),
//
//    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
//    var alerts: MutableList<Alert> = mutableListOf(),

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var histories: MutableList<History> = mutableListOf(),

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var reports: MutableList<Report> = mutableListOf()
) {
    fun makeEncryptPassword() {
        this.password = BCrypt.hashpw(this.password, BCrypt.gensalt())
    }
}