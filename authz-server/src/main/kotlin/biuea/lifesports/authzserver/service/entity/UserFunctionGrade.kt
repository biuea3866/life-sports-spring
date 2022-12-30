package biuea.lifesports.authzserver.service.entity

import biuea.lifesports.authzserver.service.constants.UserGrade
import javax.persistence.*

@Entity
@Table(name = "UserFunctionGrades")
class UserFunctionGrade(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    var grade: UserGrade,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_function_id")
    @JoinColumn(name = "user_function_id")
    var userFunction: UserFunction
) {
}