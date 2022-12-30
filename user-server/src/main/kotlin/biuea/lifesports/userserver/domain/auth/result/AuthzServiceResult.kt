package biuea.lifesports.userserver.domain.auth.result

import biuea.lifesports.authnserver.common.exception.ForbiddenException
import biuea.lifesports.userserver.domain.users.constants.UserGrade

class AuthzServiceResult {
    class GetAuthorizationUser(
        val isValidUser: Boolean,
        val grade: UserGrade
    )
}