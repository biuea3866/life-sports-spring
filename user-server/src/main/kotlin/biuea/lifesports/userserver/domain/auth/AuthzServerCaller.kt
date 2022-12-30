package biuea.lifesports.userserver.domain.auth

import biuea.lifesports.userserver.infrastructure.auth.event.AuthzServerCallerEvent

interface AuthzServerCaller {
    fun getAuthorizationUser(event: AuthzServerCallerEvent.GetAuthorizationUser): AuthzServerCallerEvent.GetAuthorizationUser
}