package biuea.lifesports.userserver.domain.auth

import biuea.lifesports.userserver.domain.auth.command.AuthzServiceCommand
import biuea.lifesports.userserver.domain.auth.result.AuthzServiceResult

class AuthzServiceImpl(val authzServerCaller: ): AuthzService {
    override fun getAuthorizationUser(command: AuthzServiceCommand.GetAuthorizationUser): AuthzServiceResult.GetAuthorizationUser {
        TODO("Not yet implemented")
    }
}