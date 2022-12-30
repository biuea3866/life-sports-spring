package biuea.lifesports.userserver.domain.users.command

import biuea.lifesports.userserver.domain.users.constants.UserGrade
import biuea.lifesports.userserver.domain.users.entity.User
import java.time.ZonedDateTime

class UsersCommandDomain {
    open class UserDomain(
        val email: String,
        val password: String,
        val nickname: String,
        val name: String?,
        val phone: String?,
    ) {
        fun toEntity(): User {
            return User(
                email = this.email,
                password = this.password,
                nickname = this.nickname,
                name = this.name,
                phone = this.phone,
                createdDate = ZonedDateTime.now(),
                grade = UserGrade.BRONZE
            )
        }
    }
}