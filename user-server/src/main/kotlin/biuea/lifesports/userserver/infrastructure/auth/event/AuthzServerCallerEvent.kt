package biuea.lifesports.userserver.infrastructure.auth.event

import biuea.lifesports.userserver.domain.users.constants.UserGrade

class AuthzServerCallerEvent {
    class GetAuthorizationUser(
        val userId: Int,
        val grades: List<UserGrade>
    )
}