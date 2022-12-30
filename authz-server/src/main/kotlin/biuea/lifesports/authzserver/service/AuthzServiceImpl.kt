package biuea.lifesports.authzserver.service

import biuea.lifesports.authzserver.service.converter.UserGradeConverter
import doodlin.greeting.grpc.proto.user.AuthzRequest
import doodlin.greeting.grpc.proto.user.AuthzResponse
import doodlin.greeting.grpc.proto.user.AuthzServiceGrpc
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.springframework.transaction.annotation.Transactional

@GrpcService
class AuthzServiceImpl(
    val usersReader: UsersReader,
    val gradeAuthoritiesReader: GradeAuthoritiesReader
): AuthzService, AuthzServiceGrpc.AuthzServiceImplBase() {
    @Transactional(readOnly = true)
    override fun getAuthorizationUser(
        request: AuthzRequest.GetAuthorizationUser,
        responseObserver: StreamObserver<AuthzResponse.GetAuthorizationUser>
    ) {
        this.usersReader.isActiveUser(userId = request.userId)
        this.gradeAuthoritiesReader.isValidGrade(
            grade = UserGradeConverter().convert(userGrade = request.grade),
            functionName = request.functionName
        )
    }
}