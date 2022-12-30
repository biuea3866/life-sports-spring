package biuea.lifesports.authzserver.service.entity

import javax.persistence.*

@Entity
@Table(name = "UserFunctions")
class UserFunction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    var functionName: String,

    @OneToMany(mappedBy = "userFunction", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var userFunctionGrades: MutableList<UserFunctionGrade> = mutableListOf()
) {
}