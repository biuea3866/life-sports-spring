package biuea.lifesports.userserver.domain.auth

import biuea.lifesports.userserver.domain.auth.command.AuthzServiceCommand
import biuea.lifesports.userserver.domain.auth.result.AuthzServiceResult

interface AuthzService {
    fun getAuthorizationUser(command: AuthzServiceCommand.GetAuthorizationUser): AuthzServiceResult.GetAuthorizationUser
}