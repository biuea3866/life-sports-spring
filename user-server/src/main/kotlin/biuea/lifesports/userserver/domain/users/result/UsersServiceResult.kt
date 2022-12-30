package biuea.lifesports.userserver.domain.users.result

import biuea.lifesports.userserver.application.users.output.UsersFacadeOutput
import biuea.lifesports.userserver.domain.users.constants.UsersMessage

class UsersServiceResult {
    class SignupV1(val user: UsersResultDomain.UserDomain) {
        fun of(): UsersFacadeOutput.Signup {
            return UsersFacadeOutput.Signup(
                userId = user.id,
                message = UsersMessage.CREATE_USER.options(options = arrayOf(this.user.name?: this.user.nickname))
            )
        }
    }
}