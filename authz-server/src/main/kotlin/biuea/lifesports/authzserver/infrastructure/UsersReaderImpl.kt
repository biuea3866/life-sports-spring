package biuea.lifesports.authzserver.infrastructure

import biuea.lifesports.authnserver.common.exception.ForbiddenException
import biuea.lifesports.authnserver.common.exception.NotFoundException
import biuea.lifesports.authzserver.service.UsersReader
import biuea.lifesports.authzserver.service.constants.UserStatus
import biuea.lifesports.authzserver.service.entity.User
import biuea.lifesports.authzserver.service.errors.UserErrors
import org.springframework.stereotype.Component

@Component
class UsersReaderImpl(val usersRepository: UsersRepository): UsersReader {
    override fun isActiveUser(userId: Long): User {
        val user = this.usersRepository.findById(userId)
            .orElseThrow { throw NotFoundException(UserErrors.of(error = UserErrors.NOT_FOUND_USER)) }

        if (user.status == UserStatus.DE_ACTIVE) throw ForbiddenException(UserErrors.of(error = UserErrors.IS_NOT_ACTIVE_USER))

        return user
    }
}