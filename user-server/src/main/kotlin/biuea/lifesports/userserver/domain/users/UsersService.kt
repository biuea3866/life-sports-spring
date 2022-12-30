package biuea.lifesports.userserver.domain.users

import biuea.lifesports.userserver.domain.users.command.UsersServiceCommand
import biuea.lifesports.userserver.domain.users.result.UsersServiceResult

interface UsersService {
    fun signup(command: UsersServiceCommand.SignupV1): UsersServiceResult.SignupV1
}