package biuea.lifesports.userserver.domain.users.result

import biuea.lifesports.userserver.domain.users.constants.UserGrade
import biuea.lifesports.userserver.domain.users.constants.UserStatus
import biuea.lifesports.userserver.domain.users.entity.User
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.ZonedDateTime

class UsersResultDomain {
    class UserDomain(
        @JsonIgnore
        private val user: User
    ) {
        val id: Long = this.user.id
        val email: String = this.user.email
        val nickname: String = this.user.nickname
        val name: String? = this.user.name
        val phone: String? = this.user.phone
        val status: UserStatus = this.user.status
        val grade: UserGrade = this.user.grade
        val createdDate: ZonedDateTime = this.user.createdDate
        val updatedDate: ZonedDateTime? = this.user.updatedDate
        val lastLoginAt: ZonedDateTime? = this.user.lastLoginAt
    }
}