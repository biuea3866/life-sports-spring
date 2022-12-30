package biuea.lifesports.userserver.application.users

import biuea.lifesports.userserver.application.users.input.UsersFacadeInput
import biuea.lifesports.userserver.application.users.output.UsersFacadeOutput
import biuea.lifesports.userserver.domain.users.UsersService
import org.springframework.stereotype.Component

@Component
class UsersFacade(val usersService: UsersService) {
    fun signup(input: UsersFacadeInput.SignupV1): UsersFacadeOutput.Signup {
        return this.usersService.signup(input.of()).of()
    }
}