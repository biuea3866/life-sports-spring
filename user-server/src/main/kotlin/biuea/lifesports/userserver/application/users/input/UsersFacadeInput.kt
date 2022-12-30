package biuea.lifesports.userserver.application.users.input

import biuea.lifesports.userserver.domain.users.command.UsersServiceCommand

class UsersFacadeInput {
    class SignupV1(
        val email: String,
        val password: String,
        val nickname: String,
        val name: String?,
        val phone: String?
    ) {
        fun of(): UsersServiceCommand.SignupV1 {
            return UsersServiceCommand.SignupV1(
                email = this.email,
                password = this.password,
                nickname = this.nickname,
                name = this.name,
                phone = this.phone
            )
        }
    }

    class ChangeUserInfoV1()
}