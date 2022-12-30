package biuea.lifesports.authzserver.service.entity

import biuea.lifesports.authzserver.service.constants.UserGrade
import biuea.lifesports.authzserver.service.constants.UserStatus
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

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var gradeAuthorities: MutableList<GradeAuthority> = mutableListOf()
)