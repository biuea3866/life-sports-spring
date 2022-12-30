package biuea.lifesports.authzserver.service

import doodlin.greeting.grpc.proto.user.AuthzRequest
import doodlin.greeting.grpc.proto.user.AuthzResponse
import doodlin.greeting.grpc.proto.user.AuthzServiceGrpc
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class AuthzServiceImpl(val usersReader: UsersReader): AuthzService, AuthzServiceGrpc.AuthzServiceImplBase() {
    override fun getAuthorizationUser(
        request: AuthzRequest.GetAuthorizationUser,
        responseObserver: StreamObserver<AuthzResponse.GetAuthorizationUser>
    ) {
        val isActive = usersReader.
    }
}