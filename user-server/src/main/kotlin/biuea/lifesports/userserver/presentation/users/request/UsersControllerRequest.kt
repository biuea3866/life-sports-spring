package biuea.lifesports.userserver.presentation.users.request

import biuea.lifesports.userserver.application.users.input.UsersFacadeInput

class UsersControllerRequest {
    class SignupV1(
        val email: String,
        val password: String,
        val nickname: String,
        val name: String?,
        val phone: String?,
    ) {
        fun of(): UsersFacadeInput.SignupV1 {
            return UsersFacadeInput.SignupV1(
                email = this.email,
                password = this.password,
                nickname = this.nickname,
                name = this.name,
                phone = this.phone
            )
        }
    }

    class ChangeUserInfoV1() {
        fun of(): UsersFacadeInput.ChangeUserInfoV1 {
            return UsersFacadeInput.ChangeUserInfoV1()
        }
    }
}