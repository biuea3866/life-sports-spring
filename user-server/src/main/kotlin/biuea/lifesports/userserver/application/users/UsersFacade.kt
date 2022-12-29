package biuea.lifesports.userserver.application.users

import biuea.lifesports.userserver.application.users.input.UsersFacadeInput
import biuea.lifesports.userserver.application.users.output.UsersFacadeOutput
import org.springframework.stereotype.Component

@Component
class UsersFacade {
    fun signup(input: UsersFacadeInput.SignupV1): UsersFacadeOutput.Signup {
        return UsersFacadeOutput.Signup(
            userId = 1,
            message = "성공"
        )
    }
}