package biuea.lifesports.userserver.infrastructure.users

import biuea.lifesports.authnserver.common.exception.ForbiddenException
import biuea.lifesports.userserver.domain.users.UsersReader
import biuea.lifesports.userserver.domain.users.errors.UserErrors
import org.springframework.stereotype.Component

@Component
class UsersReaderImpl(val usersRepository: UsersRepository): UsersReader {
    override fun isDuplicatedEmail(email: String) {
        if (this.usersRepository.existsByEmail(email = email)) throw ForbiddenException(UserErrors.of(error = UserErrors.IS_EXIST_EMAIL))
    }
}