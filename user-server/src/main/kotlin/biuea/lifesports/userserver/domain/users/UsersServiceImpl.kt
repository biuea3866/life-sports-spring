package biuea.lifesports.userserver.domain.users

import biuea.lifesports.userserver.domain.users.command.UsersServiceCommand
import biuea.lifesports.userserver.domain.users.result.UsersResultDomain
import biuea.lifesports.userserver.domain.users.result.UsersServiceResult
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UsersServiceImpl(
    val usersReader: UsersReader,
    val usersStore: UsersStore,
    val applicationEventPublisher: ApplicationEventPublisher
): UsersService {
    @Transactional
    override fun signup(command: UsersServiceCommand.SignupV1): UsersServiceResult.SignupV1 {
        this.usersReader.isDuplicatedEmail(email = command.email)

        val user = this.usersStore.createUser(event = command.toCreateUserEvent())

        this.applicationEventPublisher.publishEvent(command.toCreateUserHistory(user = user))

        return UsersServiceResult.SignupV1(user = UsersResultDomain.UserDomain(user = user))
    }

    @Transactional
    override fun getUsersInfo(command: UsersServiceCommand.GetUserInfoV1): UsersServiceResult.GetUserInfo {
        return UsersServiceResult.GetUserInfo(user = UsersResultDomain.UserDomain(user = this.usersReader.getUserInfo(userId = command.userId)))
    }
}