package biuea.lifesports.userserver.domain.auth.command

import biuea.lifesports.userserver.domain.users.constants.UserGrade

class AuthzServiceCommand {
    class GetAuthorizationUser(
        val userId: Int,
        val grades: List<UserGrade>
    )
}