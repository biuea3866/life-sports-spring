package biuea.lifesports.userserver.infrastructure

import biuea.lifesports.userserver.domain.auth.AuthzServerCaller
import biuea.lifesports.userserver.infrastructure.auth.event.AuthzServerCallerEvent
import org.springframework.web.reactive.function.client.WebClient

class AuthzServerCallerImpl(val webClient: WebClient): AuthzServerCaller {
    override fun getAuthorizationUser(event: AuthzServerCallerEvent.GetAuthorizationUser): AuthzServerCallerEvent.GetAuthorizationUser {
        TODO("Not yet implemented")
    }
}