package biuea.lifesports.authzserver.service.entity

import biuea.lifesports.authzserver.service.constants.UserGrade
import javax.persistence.*

@Entity
@Table(name = "GradeAuthorities")
class GradeAuthority(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    var functionName: String,

    var userGrade: UserGrade
) {
}