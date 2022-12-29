package biuea.lifesports.userserver.presentation.users.request

import biuea.lifesports.userserver.application.users.input.UsersFacadeInput

class UsersControllerRequest {
    class SignupV1() {
        fun of(): UsersFacadeInput.SignupV1 {
            return UsersFacadeInput.SignupV1()
        }
    }
}