package biuea.lifesports.authzserver.service

import biuea.lifesports.authzserver.service.converter.UserGradeConverter
import biuea.lifesports.grpc.authz.AuthzEvent
import biuea.lifesports.grpc.authz.AuthzProjection
import biuea.lifesports.grpc.authz.AuthzServerCallerGrpc.AuthzServerCallerImplBase
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.springframework.transaction.annotation.Transactional

@GrpcService
class AuthzServiceImpl(
    val usersReader: UsersReader,
    val userFunctionsReader: UserFunctionsReader
): AuthzService, AuthzServerCallerImplBase() {
    @Transactional(readOnly = true)
    override fun getAuthorizationUser(
        request: AuthzEvent.GetAuthorizationUser,
        responseObserver: StreamObserver<AuthzProjection.GetAuthorizationUser>
    ) {
        val user = this.usersReader.isActiveUser(userId = request.userId)
        this.userFunctionsReader.isValidFunction(
            grade = user.grade,
            functionName = request.functionName
        )

        responseObserver.onNext(
            AuthzProjection.GetAuthorizationUser.newBuilder()
                .setIsValidUser(true)
                .setUserGrade(UserGradeConverter().convertToGrpcGrade(userGrade = user.grade))
                .build()
        )
    }
}