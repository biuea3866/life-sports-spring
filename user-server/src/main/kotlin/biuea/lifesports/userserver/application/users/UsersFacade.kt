package biuea.lifesports.userserver.application.users

import biuea.lifesports.userserver.application.users.input.UsersFacadeInput
import biuea.lifesports.userserver.application.users.output.UsersFacadeOutput
import biuea.lifesports.userserver.common.authorization.annotation.AuthorizeUser
import biuea.lifesports.userserver.common.authorization.constants.FunctionName
import biuea.lifesports.userserver.domain.auth.result.AuthzServiceResult
import biuea.lifesports.userserver.domain.users.UsersService
import org.springframework.stereotype.Component

@Component
class UsersFacade(val usersService: UsersService) {
    fun signup(input: UsersFacadeInput.SignupV1): UsersFacadeOutput.Signup {
        return this.usersService.signup(command = input.of()).of()
    }

    @AuthorizeUser(functionName = [FunctionName.READ_USER_INFO])
    fun getUserInfo(input: UsersFacadeInput.GetUserInfoV1): UsersFacadeOutput.GetUserInfo {
        return this.usersService.getUsersInfo(command = input.of()).of()
    }
}