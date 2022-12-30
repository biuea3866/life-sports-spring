package biuea.lifesports.userserver.domain.auth

import biuea.lifesports.authnserver.common.exception.ForbiddenException
import biuea.lifesports.grpc.authz.AuthzServerCallerGrpc
import biuea.lifesports.grpc.authz.AuthzServerCallerGrpc.AuthzServerCallerBlockingStub
import biuea.lifesports.grpc.authz.AuthzServerCallerGrpc.AuthzServerCallerImplBase
import biuea.lifesports.userserver.domain.auth.command.AuthzServiceCommand
import biuea.lifesports.userserver.domain.auth.result.AuthzServiceResult
import biuea.lifesports.userserver.domain.users.converter.UserGradeConverter
import io.grpc.ManagedChannelBuilder
import net.devh.boot.grpc.client.inject.GrpcClient
import org.springframework.stereotype.Service

@Service
class AuthzServiceImpl(): AuthzService {
    override fun getAuthorizationUser(command: AuthzServiceCommand.GetAuthorizationUser): AuthzServiceResult.GetAuthorizationUser {
        val authzServerCaller: AuthzServerCallerBlockingStub = AuthzServerCallerGrpc.newBlockingStub(
            ManagedChannelBuilder.forAddress(
                "127.0.0.1",
                8101
            )
                .usePlaintext()
                .build()
        )
        val result = authzServerCaller.getAuthorizationUser(command.of())

        return AuthzServiceResult.GetAuthorizationUser(
            isValidUser = result.isValidUser,
            grade = UserGradeConverter().toKotlinUserGradeConvert(grade = result.userGrade)
        )
    }
}