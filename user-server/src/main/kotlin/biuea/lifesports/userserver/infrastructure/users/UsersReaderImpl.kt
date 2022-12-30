package biuea.lifesports.userserver.infrastructure.users

import biuea.lifesports.authnserver.common.exception.ForbiddenException
import biuea.lifesports.authnserver.common.exception.NotFoundException
import biuea.lifesports.userserver.domain.users.UsersReader
import biuea.lifesports.userserver.domain.users.entity.User
import biuea.lifesports.userserver.domain.users.errors.UserErrors
import org.springframework.stereotype.Component

@Component
class UsersReaderImpl(val usersRepository: UsersRepository): UsersReader {
    override fun isDuplicatedEmail(email: String) {
        if (this.usersRepository.existsByEmail(email = email)) throw ForbiddenException(UserErrors.of(error = UserErrors.IS_EXIST_EMAIL))
    }

    override fun getUserInfo(userId: Long): User {
        return this.usersRepository.findById(userId)
            .orElseThrow { throw NotFoundException(UserErrors.of(error = UserErrors.NOT_FOUND_USER)) }
    }
}