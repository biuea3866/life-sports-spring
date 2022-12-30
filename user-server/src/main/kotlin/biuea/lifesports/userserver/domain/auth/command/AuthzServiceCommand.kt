package biuea.lifesports.userserver.domain.auth.command

import biuea.lifesports.grpc.authz.AuthzEvent

class AuthzServiceCommand {
    class GetAuthorizationUser(
        val userId: Long,
        val functionName: String
    ) {
        fun of(): AuthzEvent.GetAuthorizationUser {
            return AuthzEvent.GetAuthorizationUser.newBuilder()
                .setUserId(this.userId)
                .setFunctionName(this.functionName)
                .build()
        }
    }
}