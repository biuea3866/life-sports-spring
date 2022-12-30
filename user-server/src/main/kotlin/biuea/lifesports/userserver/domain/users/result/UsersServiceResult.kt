package biuea.lifesports.userserver.domain.users.result

import biuea.lifesports.userserver.application.users.output.UsersFacadeOutput
import biuea.lifesports.userserver.domain.users.constants.UserGrade
import biuea.lifesports.userserver.domain.users.constants.UserStatus
import biuea.lifesports.userserver.domain.users.constants.UsersMessage
import java.time.ZonedDateTime

class UsersServiceResult {
    class SignupV1(val user: UsersResultDomain.UserDomain) {
        fun of(): UsersFacadeOutput.Signup {
            return UsersFacadeOutput.Signup(
                userId = user.id,
                message = UsersMessage.CREATE_USER.options(options = arrayOf(this.user.name?: this.user.nickname))
            )
        }
    }

    class GetUserInfo(val user: UsersResultDomain.UserDomain) {
        fun of(): UsersFacadeOutput.GetUserInfo {
            return UsersFacadeOutput.GetUserInfo(
                id = this.user.id,
                email = this.user.email,
                nickname = this.user.nickname,
                name = this.user.name,
                phone = this.user.phone,
                status = this.user.status,
                grade = this.user.grade,
                createdDate = this.user.createdDate,
                updatedDate = this.user.updatedDate,
                lastLoginAt = this.user.lastLoginAt
            )
        }
    }
}